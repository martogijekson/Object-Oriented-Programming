package tugas3;

import java.util.Scanner;

public class Pegawai {
    private String NIP;
    private String nama;
    private String alamat;
    private double gajiPokok;
    private int hariLembur;
    private char golongan;

    public Pegawai(String NIP, String nama, String alamat, double gajiPokok, int hariLembur, char golongan) {
        this.NIP = NIP;
        this.nama = nama;
        this.alamat = alamat;
        this.gajiPokok = gajiPokok;
        this.hariLembur = hariLembur;
        this.golongan = golongan;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public void setHariLembur(int hariLembur) {
        this.hariLembur = hariLembur;
    }

    public void setGolongan(char golongan) {
        this.golongan = golongan;
    }

    public String getNIP() {
        return NIP;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    public int getHariLembur() {
        return hariLembur;
    }

    public char getGolongan() {
        return golongan;
    }

    public double totalLembur() {
        return hariLembur * 0.01 * gajiPokok;
    }

    public double tunjanganGolongan() {
        double tunjangan = 0;
        switch (golongan) {
            case 'A':
                tunjangan = gajiPokok * 0.015;
                break;
            case 'B':
                tunjangan = gajiPokok * 0.03;
                break;
            case 'C':
                tunjangan = gajiPokok * 0.05;
                break;
        }
        return tunjangan;
    }

    public double totalGaji() {
        return gajiPokok + totalLembur() + tunjanganGolongan();
    }

    public void printInfo() {
        System.out.println("");
        System.out.println("NIP Pegawai : " + NIP);
        System.out.println("Nama Pegawai : " + nama);
        System.out.println("Alamat Pegawai : " + alamat);
        System.out.println("Gaji Pokok: " + gajiPokok + ".0");
        System.out.println("Hari Lembur : " + hariLembur);
        System.out.println("Total Lembur : " + totalLembur() + ".0");
        System.out.println("Tunjangan Golongan : " + tunjanganGolongan() + ".0");
        System.out.println("Total Gaji: " + totalGaji() + ".0");
    }
}
