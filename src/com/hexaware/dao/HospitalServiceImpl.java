package com.hexaware.dao;


import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.hexaware.entity.Appointment;
import com.hexaware.entity.Doctor;
import com.hexaware.entity.Patient;
import com.hexaware.exception.DoctorIdException;
import com.hexaware.exception.PatientNumberNotFoundException;
import com.hexaware.util.DBConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HospitalServiceImpl implements IHospitalService {

	    private Connection getConnection() throws Exception {
	        return DBConnUtil.getConnection(); // DBConnUtil should return a valid Connection
	    }

	    @Override
	    public Appointment getAppointmentById(int appointmentId) {
	        String sql = "SELECT * FROM Appointment WHERE appointmentId = ?";
	        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, appointmentId);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                return extractAppointment(rs);
	            }
	        } catch (Exception e) {
	            System.err.println("Error fetching appointment: " + e.getMessage());
	        }
	        return null;
	    }

	    @Override
	    public List<Appointment> getAppointmentsForPatient(int patientId) throws PatientNumberNotFoundException {
	        String sql = "SELECT * FROM Appointment WHERE patientId = ?";
	        List<Appointment> appointments = new ArrayList<>();

	        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, patientId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                appointments.add(extractAppointment(rs));
	            }

	            if (appointments.isEmpty()) {
	                throw new PatientNumberNotFoundException("No appointments found for patient ID: " + patientId);
	            }
	        } catch (PatientNumberNotFoundException e) {
	            throw e;
	        } catch (Exception e) {
	            System.err.println("Error: " + e.getMessage());
	        }

	        return appointments;
	    }

	    public List<Appointment> getAppointmentsForDoctor(int doctorId) {
	        String sql = "SELECT * FROM Appointment WHERE doctorId = ?";
	        List<Appointment> appointments = new ArrayList<>();

	        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, doctorId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                appointments.add(extractAppointment(rs));
	            }
	        } catch (Exception e) {
	            System.err.println("Error: " + e.getMessage());
	        }

	        return appointments;
	    }

	    public boolean registerPatient(Patient patient) {
	        String sql = "INSERT INTO Patient (patientId, name, gender,address) VALUES (?, ?, ?, ?)";
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	             
	            ps.setInt(1, patient.getPatientID());
	            ps.setString(2, patient.getFirstName());
	            ps.setString(3, patient.getGender());
	           
	            ps.setString(4, patient.getAddress());

	            
	            return ps.executeUpdate() > 0;
	        } catch (Exception e) {
	            System.err.println("Error registering patient: " + e.getMessage());
	        }
	        return false;
	    }
	    public boolean registerDoctor(Doctor doctor) {
	        String sql = "INSERT INTO Doctor (doctorId, name, specialization, contact) VALUES (?, ?, ?, ?)";
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	             
	            ps.setInt(1, doctor.getDoctorID());
	            ps.setString(2, doctor.getFirstName());
	            ps.setString(3, doctor.getSpecialzation());
	            ps.setLong(4, doctor.getContactnumber());
	            
	            return ps.executeUpdate() > 0;
	        } catch (Exception e) {
	            System.err.println("Error registering doctor: " + e.getMessage());
	        }
	        return false;
	    }

	    @Override
	    public boolean scheduleAppointment(Appointment appointment) {
	        String sql = "INSERT INTO Appointment (appointmentId, patientId, doctorId, appointmentDate, description) VALUES (?, ?, ?, ?, ?)";
	        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, appointment.getAppoinmentID());
	            ps.setInt(2, appointment.getPatientID());
	            ps.setInt(3, appointment.getDoctorID());
	            ps.setDate(4, Date.valueOf(appointment.getAppoinmentdate()));
	            ps.setString(5, appointment.getDescription());

	            return ps.executeUpdate() > 0;
	        } catch (Exception e) {
	            System.err.println("Failed to schedule appointment: " + e.getMessage());
	        }
	        return false;
	    }

	    @Override
	    public boolean updateAppointment(Appointment appointment) {
	        String sql = "UPDATE Appointment SET patientId = ?, doctorId = ?, appointmentDate = ?, description = ? WHERE appointmentId = ?";
	        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, appointment.getPatientID());
	            ps.setInt(2, appointment.getDoctorID());
	            ps.setDate(3, Date.valueOf(appointment.getAppoinmentdate()));
	            ps.setString(4, appointment.getDescription());
	            ps.setInt(5, appointment.getAppoinmentID());

	            return ps.executeUpdate() > 0;
	        } catch (Exception e) {
	            System.err.println("Failed to update appointment: " + e.getMessage());
	        }
	        return false;
	    }

	    @Override
	    public boolean cancelAppointment(int appointmentId) {
	        String sql = "DELETE FROM Appointment WHERE appointmentId = ?";
	        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, appointmentId);
	            return ps.executeUpdate() > 0;
	        } catch (Exception e) {
	            System.err.println("Failed to cancel appointment: " + e.getMessage());
	        }
	        return false;
	    }

	    // Helper method to extract Appointment object from ResultSet
	    private Appointment extractAppointment(ResultSet rs) throws SQLException {
	        return new Appointment(
	            rs.getInt("appointmentId"),
	            rs.getInt("patientId"),
	            rs.getInt("doctorId"),
	            rs.getDate("appointmentDate").toString(),
	            rs.getString("description")
	        );
	    }

		@Override
		public Appointment getAppointmentByID(int AppointmentID) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Appointment> getAppointmentForPatient(int patientID) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Appointment> getAppointmentForDoctor(int doctorID) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	








