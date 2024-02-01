
package uts;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Inputan dari user
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan tinggi badan (cm): ");
        double tinggiBadan = sc.nextDouble();
        System.out.print("Masukkan jenis kelamin (L/P): ");
        String jenisKelamin = sc.next();

        
        Manusia manusia = null;
        if (jenisKelamin.equals("L")) {
            manusia = new LakiLaki(tinggiBadan);
        } else if (jenisKelamin.equals("P")) {
            manusia = new Perempuan(tinggiBadan);
        } else {
            System.out.println("Input jenis kelamin salah!");
            System.exit(0);
        }

        // Hitung BBI
        double bbi = manusia.hitBBI();

        // Tampilkan hasil
        System.out.println("Berat badan ideal " + manusia.getJK() + ": " + bbi);
    }
}