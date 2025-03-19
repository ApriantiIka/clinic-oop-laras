/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4.Guided.driver;

import Modul4.Guided.hargabuku.KelasHarga;
import Modul4.Guided.hargatoken.KelasToken;

/**
 *
 * @author USER
 */
public class TestPackage {
    public static void main(String[] args) {
        KelasToken token = new KelasToken();
        KelasHarga harga = new KelasHarga();
        token.info();
        harga.info();
    }
}
