package com.hexaware.entity;

import java.time.LocalDate;

public class Appointment {
	private int appoinmentID;
    private int patientID;
    private int doctorID;
    private String appoinmentdate;
    private String description;
	public int getAppoinmentID() {
		return appoinmentID;
	}
	public void setAppoinmentID(int appoinmentID) {
		this.appoinmentID = appoinmentID;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public String getAppoinmentdate() {
		return appoinmentdate;
	}
	public void setAppoinmentdate(String appoinmentdate) {
		this.appoinmentdate = appoinmentdate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Appointment(int appoinmentID, int patientID, int doctorID, String localDate, String description) {
		super();
		this.appoinmentID = appoinmentID;
		this.patientID = patientID;
		this.doctorID = doctorID;
		this.appoinmentdate = localDate;
		this.description = description;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(int int1, int int2, int int3, LocalDate object, String string) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Appoinment [appoinmentID=" + appoinmentID + ", patientID=" + patientID + ", doctorID=" + doctorID
				+ ", appoinmentdate=" + appoinmentdate + ", description=" + description + "]";
	}
    
}
