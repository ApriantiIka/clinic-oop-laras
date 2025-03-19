/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4.Unguided.entities;

/**
 *
 * @author USER
 */
public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String date;
    
    public Appointment(Doctor doctor, Patient patient, String date){
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        doctor.addAppointment(this);
    }
    
    public Doctor getDoctor(){
        return doctor;
    }
    
    public Patient getPatient(){
        return patient;
    }
    
    public String getDate(){
        return date;
    }
    
    public void printInfo(){
        System.out.println("Appointment: " + doctor.getName() + " with " + patient.getName() + " on " + date);
    }
    
    public static void main(String[] args) {
        // Create doctor and patient
        Doctor doc = new Doctor("D001", "Dr. Cinta");
        Patient pat = new Patient("P001", "Ms. Alison Swift", "Flu");
        
        //Validate IDs
        DataChecker.validateId(doc.getId());
        DataChecker.validateId(pat.getId());
        
        // Create appointment
        Appointment app = new Appointment(doc, pat, "2025-03-17");
        
        // Print details
        doc.printInfo();
        pat.printInfo();
        app.printInfo();
        
        // Show diagnosis count
        System.out.println("Total Diagnoses recorded: " + DiagnosisCounter.getDiagnosisCount());
    }
}
