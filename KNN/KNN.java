/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;

public class KNN {

    public static double HitungJarakEuclidean(dataLatih lat, dataUji uji) {
        double jarak = 0;
        jarak = Math.sqrt(((lat.getPanjang() - uji.getPanjang()) * (lat.getPanjang() - uji.getPanjang()))
                + ((lat.getLebar() - uji.getLebar()) * (lat.getLebar() - uji.getLebar())));
        return jarak;
    }

    public static ArrayList<dataLatih> urutRank(ArrayList<dataLatih> data) {
        dataLatih temp;
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = 0; j < data.size() - 1; j++) {
                if (data.get(j).getEuclidean() > data.get(j + 1).getEuclidean()) {
                    temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
        return data;
    }

    public static String cariKNN(ArrayList<dataLatih> data, int k) {

        String[] baru = new String[k + 1];
        String temp = "";
        int count = 0;
        int freq = 0;
        String res = "";
        if ((k > data.size()) || (k <= 0)) {
            return "ERROR: harap masukkan nilai k yang sesuai";
        }
        if (k != 1) {
            for (int i = 0; i < k; i++) {
                baru[i] = data.get(i).getLabel();
            }
            for (int i = 0; i < k; i++) {
                for (int j = i + 1; j < k; j++) {
                    if (baru[j].equals(baru[i])) {
                        count++;
                    }
                    if (count >= freq) {
                        res = baru[i];
                    } else if (count == freq) {
                        res = "eror";
                    }
                }
            }
        } else {
            return data.get(1).getLabel();
        }
        return "Hasil KNN dengan k = " + k + " adalah " + "\"" + res + "\"";
    }

    public static void main(String[] args) throws FileNotFoundException {
        
//         File file = new File("\"D:\\KULIAH\\Materi Kuliah\\Pengenalan Pola E\\Laporan\\3-fold cross validation_kelA.xlsx\"");
//         FileInputStream fis = new FileInputStream(file);
//                     
        dataLatih latih1 = new dataLatih("Alpukat", 9, 3.5);
        dataLatih latih2 = new dataLatih("Alpukat", 9, 3.5);
        dataLatih latih3 = new dataLatih("Alpukat", 8, 3);
        dataLatih latih4 = new dataLatih("Dafnah", 2, 7.9);
        dataLatih latih5 = new dataLatih("Dafnah", 2, 9.6);
        dataUji uji1 = new dataUji("Alpukat", 7.5, 3);

        ArrayList<dataLatih> dataLatih = new ArrayList<dataLatih>();
        ArrayList<dataUji> dataUji = new ArrayList<dataUji>();

        dataLatih.add(latih1);
        dataLatih.add(latih2);
        dataLatih.add(latih3);
        dataLatih.add(latih4);
        dataLatih.add(latih5);

        for (int i = 0; i < dataLatih.size(); i++) {
            dataLatih.get(i).setEuclidean(HitungJarakEuclidean(dataLatih.get(i), uji1));
        }

        ArrayList<dataLatih> dataUrut = urutRank(dataLatih);

        System.out.println(dataUrut);

        System.out.println("\n" + cariKNN(dataUrut, 5));
    }
}
