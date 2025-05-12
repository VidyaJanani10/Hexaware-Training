package com.hexaware.entity;

public class Doctor {
   
	private int doctorID;
    private String firstName;
    private String lastName;
    private String specialzation;
    private int contactnumber;
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSpecialzation() {
		return specialzation;
	}
	public void setSpecialzation(String specialzation) {
		this.specialzation = specialzation;
	}
	public int getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(int contactnumber) {
		this.contactnumber = contactnumber;
	}
	public Doctor(int doctorID, String firstName, String lastName, String specialzation, int contactnumber) {
		super();
		this.doctorID = doctorID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialzation = specialzation;
		this.contactnumber = contactnumber;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Doctor [doctorID=" + doctorID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", specialzation=" + specialzation + ", contactnumber=" + contactnumber + "]";
	}

	
	
}
