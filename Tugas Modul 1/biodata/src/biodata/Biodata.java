package biodata;
import java.util.Scanner;

public class Biodata {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan Nama Lengkap Anda: ");
            String namaLengkap = input.nextLine();
            
            System.out.print("Masukkan Nama Panggilan Anda: ");
            String namaPanggilan = input.nextLine();
            
            System.out.print("Masukkan NIM Anda: ");
            String nim = input.nextLine();
            
            System.out.print("Masukkan Umur Anda: ");
            int umur = input.nextInt();
            input.nextLine(); // Membersihkan newline character dari input sebelumnya
            
            System.out.print("Masukkan Tempat Lahir Anda: ");
            String tempatLahir = input.nextLine();
            
            System.out.print("Masukkan Nomor Telepon Anda: ");
            String telepon = input.nextLine();
            
            System.out.print("Masukkan Alamat Anda: ");
            String alamat = input.nextLine();
            
            // Menampilkan output dengan pemformatan
            System.out.printf("Hello, Let me introduce myself.%n");
            System.out.printf("My name is %s, but you can call me %s.%n", namaLengkap, namaPanggilan);
            System.out.printf("My NIM is %s.%n", nim);
            System.out.printf("I was born in %s and I am %d years old.%n", tempatLahir, umur);
            System.out.printf("I am very glad if you want to invite me to your house in:%n%s.%n", alamat);
            System.out.printf("So, dont forget to call me before with the number %s. Thank you.%n", telepon);
        }
    }
}