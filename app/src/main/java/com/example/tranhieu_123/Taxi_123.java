package com.example.tranhieu_123;

public class Taxi_123 implements Comparable<Taxi_123>{
    private int Ma;
    private String Bienso;
    private float Quangduong;
    private int Dongia,Khuyenmai;

    public Taxi_123(int ma, String bienso, float quangduong, int dongia, int khuyenmai) {
        Ma = ma;
        Bienso = bienso;
        Quangduong = quangduong;
        Dongia = dongia;
        Khuyenmai = khuyenmai;
    }

    public Taxi_123() {
    }

    public int getMa() {
        return Ma;
    }

    public void setMa(int ma) {
        Ma = ma;
    }

    public String getBienso() {
        return Bienso;
    }

    public void setBienso(String bienso) {
        Bienso = bienso;
    }

    public float getQuangduong() {
        return Quangduong;
    }

    public void setQuangduong(float quangduong) {
        Quangduong = quangduong;
    }

    public int getDongia() {
        return Dongia;
    }

    public void setDongia(int dongia) {
        Dongia = dongia;
    }

    public int getKhuyenmai() {
        return Khuyenmai;
    }

    public void setKhuyenmai(int khuyenmai) {
        Khuyenmai = khuyenmai;
    }

    @Override
    public int compareTo(Taxi_123 taxi_123) {
        if(this.getBienso().compareTo(taxi_123.getBienso())>0)
            return 1;
        if(this.getBienso().compareTo(taxi_123.getBienso())<0)
            return -1;
        return 0;
    }
}
