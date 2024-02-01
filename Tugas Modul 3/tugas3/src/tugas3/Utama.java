package tugas3;

import java.util.Scanner;

public class Utama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Konstruktor Pegawai dijalankan...!");

        System.out.print("Masukkan NIP Pegawai: ");
        String NIP = scanner.nextLine();

        System.out.print("Masukkan Nama Pegawai: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Alamat Pegawai: ");
        String alamat = scanner.nextLine();

        System.out.print("Masukkan Gaji Pokok Pegawai: ");
        double gajiPokok = scanner.nextDouble();

        System.out.print("Masukkan Hari Lembur Pegawai: ");
        int hariLembur = scanner.nextInt();

        System.out.print("Masukkan Golongan Pegawai (A, B, atau C): ");
        char golongan = scanner.next().charAt(0);

        Pegawai pegawai = new Pegawai(NIP, nama, alamat, gajiPokok, hariLembur, golongan);
        pegawai.printInfo();
    }
}
