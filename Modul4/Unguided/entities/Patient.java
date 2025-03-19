/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4.Unguided.entities;

/**
 *
 * @author USER
 */
public class Patient {
    private String id;
    private String name;
    private String diagnosis;
    
    public Patient(String id, String name, String diagnosis){
        this.id = id;
        this.name = name;
        this.diagnosis = diagnosis;
        DiagnosisCounter.addDiagnosis();
    }
    
    public String getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDiagnosis(){
        return "Access Denied"; // Secure data
    }
    
    public void printInfo(){
        System.out.println("Patient ID: " + id + ", Name: " + name);
    }
}
    