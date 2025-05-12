package com.hexaware.main;

import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.HospitalServiceImpl;
import com.hexaware.entity.Appointment;
import com.hexaware.entity.Patient;
import com.hexaware.exception.PatientNumberNotFoundException;

public class Main {
	    public static void main(String[] args) {
	        HospitalServiceImpl service = new HospitalServiceImpl();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n--- Hospital Management System Menu ---");
	            System.out.println("1. Get Appointment by ID");
	            System.out.println("2. Get Appointments for Patient");
	            System.out.println("3. Get Appointments for Doctor");
	            System.out.println("4. Schedule Appointment");
	            System.out.println("5. Update Appointment");
	            System.out.println("6. Cancel Appointment");
	            System.out.println("7. Register Patient");

	            System.out.println("8. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = sc.nextInt();
	            sc.nextLine(); // Clear buffer

	            try {
	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter Appointment ID: ");
	                        int aid = sc.nextInt();
	                        Appointment ap = service.getAppointmentById(aid);
	                        System.out.println(ap != null ? ap : "Appointment not found.");
	                        break;

	                    case 2:
	                        System.out.print("Enter Patient ID: ");
	                        int pid = sc.nextInt();
	                        service.getAppointmentsForPatient(pid).forEach(System.out::println);
	                        break;

	                    case 3:
	                        System.out.print("Enter Doctor ID: ");
	                        int did = sc.nextInt();
	                        service.getAppointmentsForDoctor(did).forEach(System.out::println);
	                        break;

	                    case 4:
	                        System.out.print("Enter Appointment ID: ");
	                        int newId = sc.nextInt();
	                        System.out.print("Enter Patient ID: ");
	                        int newPid = sc.nextInt();
	                        System.out.print("Enter Doctor ID: ");
	                        int newDid = sc.nextInt();
	                        sc.nextLine();
	                        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
	                        String date = sc.nextLine();
	                        System.out.print("Enter Description: ");
	                        String desc = sc.nextLine();

	                        Appointment newApp = new Appointment(newId, newPid, newDid, date, desc);
	                        boolean scheduled = service.scheduleAppointment(newApp);
	                        System.out.println(scheduled ? "Appointment scheduled successfully." : "Failed to schedule.");
	                        break;

	                    case 5:
	                        System.out.print("Enter Appointment ID to update: ");
	                        int upId = sc.nextInt();
	                        System.out.print("Enter New Patient ID: ");
	                        int upPid = sc.nextInt();
	                        System.out.print("Enter New Doctor ID: ");
	                        int upDid = sc.nextInt();
	                        sc.nextLine();
	                        System.out.print("Enter New Date (YYYY-MM-DD): ");
	                        String upDate = sc.nextLine();
	                        System.out.print("Enter New Description: ");
	                        String upDesc = sc.nextLine();

	                        Appointment upApp = new Appointment(upId, upPid, upDid, upDate, upDesc);
	                        boolean updated = service.updateAppointment(upApp);
	                        System.out.println(updated ? "Appointment updated successfully." : "Failed to update.");
	                        break;

	                    case 6:
	                        System.out.print("Enter Appointment ID to cancel: ");
	                        int delId = sc.nextInt();
	                        boolean cancelled = service.cancelAppointment(delId);
	                        System.out.println(cancelled ? "Appointment cancelled successfully." : "Failed to cancel.");
	                        break;
	               

	                    case 7:
	                        System.out.println("Exiting...");
	                        sc.close();
	                        System.exit(0);
	                        break;

	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	            } catch (PatientNumberNotFoundException pnfe) {
	                System.err.println("Error: " + pnfe.getMessage());
	            } catch (Exception e) {
	                System.err.println("Unexpected error: " + e.getMessage());
	            }
	        }
	    }
	}
	