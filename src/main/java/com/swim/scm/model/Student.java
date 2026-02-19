package com.swim.scm.model;

public class Student {

		private int id;
		private String fullName;
	    private String address;
	    private String mobileNo;
	    private String nationality;
	    private String maritalStatus;
	    private String dob;
	    private int age;
	    private String occupation;
	    private String batch;
	    private String admissionDate;
	    private String paymentMode;
	    private double totalFees;
	    private double paidAmount;
	    
	 
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getNationality() {
			return nationality;
		}
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		public String getMaritalStatus() {
			return maritalStatus;
		}
		public void setMaritalStatus(String maritalStatus) {
			this.maritalStatus = maritalStatus;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		public String getBatch() {
			return batch;
		}
		public void setBatch(String batch) {
			this.batch = batch;
		}
		public String getAdmissionDate() {
			return admissionDate;
		}
		public void setAdmissionDate(String admissionDate) {
			this.admissionDate = admissionDate;
		}
		public String getPaymentMode() {
			return paymentMode;
		}
		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public double getTotalFees() { return totalFees; }
	    public void setTotalFees(double totalFees) { this.totalFees = totalFees; }

	    public double getPaidAmount() { return paidAmount; }
	    public void setPaidAmount(double paidAmount) { this.paidAmount = paidAmount; }

	    public double getPendingFees() {
	        return totalFees - paidAmount;
	    }

	    
}
