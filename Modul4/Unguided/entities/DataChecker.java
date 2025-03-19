/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4.Unguided.entities;

/**
 *
 * @author USER
 */
public class DataChecker {
    public static boolean validateId(String id){
        boolean isValid = id.matches("D\\d{3}") || id.matches("P\\d{3}");
        System.out.println("ID " + id + " is valid" + isValid);
        return isValid;
    }
}
