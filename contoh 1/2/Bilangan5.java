//****************************************************************
// Program 9.5
// Bilangan5.java
// Penulis : Benyamin L Sinaga
//
// Menyatakan sebuah kelas yang menunjukkan pembacaan elemen suatu
// array berdasarkan indeks tertentu
//****************************************************************
import javax.swing.*;

public class Bilangan5
{
	public static void main (String args[])
	{
		int array[]={0,2,5,7,8};
		int indeks;

		String strIndeks = JOptionPane.showInputDialog(null, "Masukkan Indeks");
		indeks = Integer.parseInt(strIndeks);

		System.out.println("Nilai dengan indeks " + strIndeks + " : " + array[indeks]);

		System.out.println("Selesai ...");
	}
}
