package com.swim.scm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.swim.scm.DBConnection;
import com.swim.scm.model.Student;

public class BatchWiseDAO {

	public List<Student> getStudentByBatch(String batch) {
			
	    List<Student> list = new ArrayList<>();

	    String sql = "SELECT * FROM students WHERE batch = ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, batch);

	        try (ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {

	                Student s = new Student();

	                s.setId(rs.getInt("id"));
	                s.setFullName(rs.getString("full_name"));
	                s.setMobileNo(rs.getString("mobile_no"));
	                s.setBatch(rs.getString("batch"));
	                s.setTotalFees(rs.getDouble("total_fees"));
	                s.setPaidAmount(rs.getDouble("paid_amount"));

	                list.add(s);   // 🔥 VERY IMPORTANT
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	

}
