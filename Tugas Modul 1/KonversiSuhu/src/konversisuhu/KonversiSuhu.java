package konversisuhu;

import java.util.Scanner;

public class KonversiSuhu {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan suhu dalam Celsius (C): ");
            double celsius = input.nextDouble();
            
            double fahrenheit = celsius * 9/5 + 32;
            double reamur = 0.8 * celsius;
            double kelvin = celsius + 273.15;
            
            System.out.println("Hasil konversi suhu:");
            System.out.println("Celsius (C): " + celsius);
            System.out.println("Fahrenheit (F): " + fahrenheit);
            System.out.println("Reamur (R): " + reamur);
            System.out.println("Kelvin (K): " + kelvin);
            
            input.close();
        }
    }
}
