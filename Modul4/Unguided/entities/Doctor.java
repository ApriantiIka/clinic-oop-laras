/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4.Unguided.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Doctor {
    private String id;
    private String name;
    private List<Appointment>appointments;
    
    public Doctor(String id, String name){
        this.id = id;
        this.name = name;
        this.appointments = new ArrayList<>();
    }
    
    public String getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public List<Appointment> getAppointments(){
        return appointments;
    }
    
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
    
    public void printInfo(){
        System.out.println("Doctor ID: " + id + ", Name: " + name);
    }
}
