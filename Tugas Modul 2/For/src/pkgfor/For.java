package pkgfor;

import java.util.Scanner;

public class For {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan angka: ");
        double angka = input.nextDouble();
        
        System.out.print("Masukkan nilai pangkat: ");
        int pangkat = input.nextInt();
        
        double hasil = 1;
        
        for (int i = 0; i < pangkat; i++) {
            hasil *= angka;
        }
        
        System.out.println(angka + " pangkat " + pangkat + " = " + hasil);
    }
}
