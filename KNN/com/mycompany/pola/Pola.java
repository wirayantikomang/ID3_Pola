/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pola;

/**
 *
 * @author ASUS
 */
public class Pola {
    public static void main(String[] args) {
    double [] panjang = {7.5, 9, 9, 2, 2.2, 2.3, 2.1, 2.1, 3};
    double [] lebar = {3, 4, 4, 11.1, 11.3, 12, 10.8, 5.3, 5.9};
    String [] kelas = {"alpukat", "alpukat", "alpukat", "dafnah", "dafnah", 
        "dafnah", "dafnah", "wungu", "wungu", "wungu"};
    
    double panjang1 = 3;
    double lebar1 = 4;
    
        for (int i = 0; i < panjang.length; i++) {
          double pj= (Math.sqrt(Math.pow(panjang[i] - panjang1, 2)+ Math.pow(lebar[i] - lebar1,2)));
            System.out.println("Data ke " + (i+1) + ": " + pj);
        }
        
    }
}

