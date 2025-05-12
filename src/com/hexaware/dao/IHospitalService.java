package com.hexaware.dao;

import java.util.List;

import com.hexaware.entity.Appointment;

public interface IHospitalService {
 Appointment  getAppointmentByID(int AppointmentID);
 List<Appointment> getAppointmentForPatient(int patientID);
 List<Appointment> getAppointmentForDoctor(int doctorID);
 boolean scheduleAppointment(Appointment appointment);
 boolean updateAppointment(Appointment appointment);
 boolean cancelAppointment(int appointmentId);
Appointment getAppointmentById(int appointmentId);
List<Appointment> getAppointmentsForPatient(int patientId);
 
}
