//****************************************************************
// Program 9.6
// Bilangan6.java
// Penulis : Benyamin L Sinaga
//
// Menyatakan sebuah kelas yang menunjukkan pelemparan eksepsi
//****************************************************************
import javax.swing.*;

public class Bilangan6
{
	public static void main (String args[])
	{
		int array[]={0,2,5,7,8};
		int idx;

		String strIdx = JOptionPane.showInputDialog(null, "Masukkan Indeks");

		try {
			idx = Integer.parseInt(strIdx);

			// check apakah indeks masukan adalah negatif
			// jika ya lemparkan eksepsi

			if (idx < 0)
			{
				throw new Exception ("Bilangan negatif tidak boleh ..");
			}

			System.out.println("Indeks : " + strIdx + " : " + array[idx]);

		}

		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("elemen tidak ada ....");
		}

		catch (Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}

		System.out.println("Selesai ...");
	}
}
