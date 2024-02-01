package nilai;

import java.util.Scanner;

public class Nilai {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan jumlah nilai yang akan diinputkan: ");
            int jumlahNilai = input.nextInt();
            
            // Membuat array untuk menyimpan nilai-nilai
            double[] nilai = new double[jumlahNilai];
            
            // Memasukkan nilai-nilai ke dalam array
            for (int i = 0; i < jumlahNilai; i++) {
                System.out.print("Masukkan nilai ke-" + (i + 1) + ": ");
                nilai[i] = input.nextDouble();
            }
            
            // Menghitung total nilai
            double total = 0;
            for (int i = 0; i < jumlahNilai; i++) {
                total += nilai[i];
            }
            
            // Menghitung rata-rata
            double rataRata = total / jumlahNilai;
            
            // Mencari nilai tertinggi dan terendah
            double nilaiTertinggi = nilai[0];
            double nilaiTerendah = nilai[0];
            for (int i = 1; i < jumlahNilai; i++) {
                if (nilai[i] > nilaiTertinggi) {
                    nilaiTertinggi = nilai[i];
                }
                if (nilai[i] < nilaiTerendah) {
                    nilaiTerendah = nilai[i];
                }
            }
            
            // Menampilkan hasil
            System.out.println("Total nilai: " + total);
            System.out.println("Rata-rata nilai: " + rataRata);
            System.out.println("Nilai tertinggi: " + nilaiTertinggi);
            System.out.println("Nilai terendah: " + nilaiTerendah);
        }
    }
}
