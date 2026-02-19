package com.swim.scm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.swim.scm.DBConnection;
import com.swim.scm.model.Student;

public class StudentDAO {
	public boolean saveStudent(Student student) {

        boolean status = false;

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO students (full_name, address, mobile_no, nationality, marital_status, dob, age, occupation, batch, admission_date, payment_mode, total_fees, paid_amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, student.getFullName());
            ps.setString(2, student.getAddress());
            ps.setString(3, student.getMobileNo());
            ps.setString(4, student.getNationality());
            ps.setString(5, student.getMaritalStatus());
            ps.setString(6, student.getDob());
            ps.setInt(7, student.getAge());
            ps.setString(8, student.getOccupation());
            ps.setString(9, student.getBatch());
            ps.setString(10, student.getAdmissionDate());
            ps.setString(11, student.getPaymentMode());
            ps.setDouble(12, student.getTotalFees());
            ps.setDouble(13, student.getPaidAmount());
            
            int row = ps.executeUpdate();

            if (row > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

	
	//View all students
	public List<Student> getAllStudents() {

	    List<Student> list = new ArrayList<>();

	    try {
	        Connection conn = DBConnection.getConnection();
	        String sql = "SELECT * FROM students";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Student s = new Student();

	            s.setId(rs.getInt("id"));
	            s.setFullName(rs.getString("full_name"));
	            s.setMobileNo(rs.getString("mobile_no"));
	            s.setBatch(rs.getString("batch"));
	            s.setPaymentMode(rs.getString("payment_mode"));
	            s.setTotalFees(rs.getDouble("total_fees"));
	            s.setPaidAmount(rs.getDouble("paid_amount"));


	            list.add(s);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}

//Get Student by ID
	public Student getStudentById(int id) {
	    Student s = null;
	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE id=?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            s = new Student();
	            s.setId(rs.getInt("id"));
	            s.setFullName(rs.getString("full_name"));
	            s.setAddress(rs.getString("address"));
	            s.setMobileNo(rs.getString("mobile_no"));
	            s.setNationality(rs.getString("nationality"));    
	            s.setMaritalStatus(rs.getString("marital_status"));
	            s.setAge(rs.getInt("age"));
	            s.setOccupation(rs.getString("occupation"));
	            s.setBatch(rs.getString("batch"));
	            s.setPaymentMode(rs.getString("payment_mode"));
	            s.setTotalFees(rs.getDouble("total_fees"));
	            s.setPaidAmount(rs.getDouble("paid_amount"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return s;
	}


	//Update Student
	public void updateStudent(Student s) {
	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(
	            "UPDATE students SET full_name=?, mobile_no=?, batch=?, payment_mode=?, total_fees=?, paid_amount=? WHERE id=?"
	        );

	        ps.setString(1, s.getFullName());
	        ps.setString(2, s.getMobileNo());
	        ps.setString(3, s.getBatch());
	        ps.setString(4, s.getPaymentMode());
	        ps.setDouble(5, s.getTotalFees());
	        ps.setDouble(6, s.getPaidAmount());
	        ps.setInt(7, s.getId());

	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

//Delete Student
	public void deleteStudent(int id) {
	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?");
	        ps.setInt(1, id);
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
//Total fees of all student
	public double getTotalFees() {
	    double totalfees = 0;
	    try {
	        Connection conn = DBConnection.getConnection();
	        String sql = "SELECT SUM(total_fees) FROM students";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            totalfees = rs.getDouble(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return totalfees;
	}

	
	
//Fees summary on Dashboard
	public double getTotalPendingFees() {
	    double total = 0;
	    try {
	        Connection conn = DBConnection.getConnection();
	        String sql = "SELECT SUM(total_fees - paid_amount) FROM students";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            total = rs.getDouble(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return total;
	}

//All Student Count
	public int getStudentCount() {

	    int count = 0;

	    try {
	        Connection conn = DBConnection.getConnection();

	        String sql = "SELECT COUNT(*) FROM students";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            count = rs.getInt(1);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return count;
	}
	
}
