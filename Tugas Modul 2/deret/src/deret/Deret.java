package deret;

import java.util.Scanner;

public class Deret {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input nilai: ");
        int nilai = input.nextInt();

        int totalGenap = 0;
        int totalGanjil = 0;

        System.out.print("Bilangan ganjil: ");
        for (int i = 1; i <= nilai; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
                totalGanjil += i;
            }
        }

        System.out.println("= " + totalGanjil);

        System.out.print("Bilangan genap: ");
        for (int i = 1; i <= nilai; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
                totalGenap += i;
            }
        }

        System.out.println("= " + totalGenap);
    }
}
