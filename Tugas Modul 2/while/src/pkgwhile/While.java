package pkgwhile;

import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan angka: ");
        double angka = input.nextDouble();
        
        System.out.print("Masukkan nilai pangkat: ");
        int pangkat = input.nextInt();
        
        double hasil = 1;
        int counter = 0;
        
        while (counter < pangkat) {
            hasil *= angka;
            counter++;
        }
        
        System.out.println(angka + " pangkat " + pangkat + " = " + hasil);
    }
}