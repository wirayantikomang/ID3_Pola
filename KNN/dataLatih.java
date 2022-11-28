/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class dataLatih {
    
    private String label;
    private double panjang;
    private double lebar;
    private double euclidean;
    private int rank;

    public dataLatih(String label, double panjang, double lebar) {
        this.label = label;
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public String getLabel() {
        return label;
    }

    public double getPanjang() {
        return panjang;
    }

    public double getLebar() {
        return lebar;
    }

    public int getRank() {
        return rank;
    }

    public double getEuclidean() {
        return euclidean;
    }

    public void setEuclidean(double euclidean) {
        this.euclidean = euclidean;
    }
    
    

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Kelas : " + this.getLabel() + "\n"
                + "Panjang(" + this.getPanjang() + "), Lebar(" +this.getLebar()+ "), Euclidean(" +this.getEuclidean()+ ")\n";
    }
}

