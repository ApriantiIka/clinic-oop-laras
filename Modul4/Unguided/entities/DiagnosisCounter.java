/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4.Unguided.entities;

/**
 *
 * @author USER
 */
public class DiagnosisCounter {
    private static int count = 0;
    
    public static void addDiagnosis(){
        count++;
        System.out.println("New diagnosis recorded. Total diagnosis: " + count);
    }
    
    public static int getDiagnosisCount(){
        return count;
    }
}
