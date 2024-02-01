package ifelse;
import java.util.Scanner;
public class Ifelse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka antara 1-10: ");
        int angka = input.nextInt();

        if (angka >= 1 && angka <= 10) {
            String kata = "";

            if (angka == 1) {
                kata = "Satu";
            } else if (angka == 2) {
                kata = "Dua";
            } else if (angka == 3) {
                kata = "Tiga";
            } else if (angka == 4) {
                kata = "Empat";
            } else if (angka == 5) {
                kata = "Lima";
            } else if (angka == 6) {
                kata = "Enam";
            } else if (angka == 7) {
                kata = "Tujuh";
            } else if (angka == 8) {
                kata = "Delapan";
            } else if (angka == 9) {
                kata = "Sembilan";
            } else if (angka == 10) {
                kata = "Sepuluh";
            }

            System.out.println("Kata yang sesuai dengan angka " + angka + " adalah: " + kata);
        } else {
            System.out.println("Invalid number");
        }
    }
}
