package konversiwaktu;

import java.util.Scanner;

public class KonversiWaktu {
    public static void main(String[] args) {
        
        try (Scanner input = new Scanner(System.in)) {
            
            // Meminta pengguna untuk memasukkan jumlah detik
            System.out.print("Masukkan jumlah detik: ");
            int totalDetik = input.nextInt();
            
            // Menghitung jam, menit, dan detik
            int jam = totalDetik / 3600;
            int sisaDetik = totalDetik % 3600;
            int menit = sisaDetik / 60;
            int detik = sisaDetik % 60;
            
            // Menampilkan hasil konversi waktu
            System.out.println("Hasil konversi waktu:");
            System.out.println("Jam: " + jam);
            System.out.println("Menit: " + menit);
            System.out.println("Detik: " + detik);
            
            input.close();
        }
    }
}