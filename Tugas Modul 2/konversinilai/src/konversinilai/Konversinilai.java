package konversinilai;

import java.util.Scanner;

public class Konversinilai {

public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
        System.out.print("Masukkan nilai Anda: ");
        int nilai = input.nextInt();

        char nilaiHuruf = konversiNilaiKeHuruf(nilai);

        System.out.println("Nilai Anda dalam bentuk huruf: " + nilaiHuruf);
    }
    }

    public static char konversiNilaiKeHuruf(int nilai) {
        char nilaiHuruf;
        
        if (nilai >= 85 && nilai <= 100) {
            nilaiHuruf = 'A';
        } else if (nilai >= 70 && nilai <= 84) {
            nilaiHuruf = 'B';
        } else if (nilai >= 60 && nilai < 70) {
            nilaiHuruf = 'C';
        } else if (nilai >= 50 && nilai < 60) {
            nilaiHuruf = 'D';
        } else {
            nilaiHuruf = 'E';
        }

        return nilaiHuruf;
    }
}
