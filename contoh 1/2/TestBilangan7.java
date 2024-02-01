//****************************************************************
// Program 9.9
// TestBilangan7.java
// Penulis : Benyamin L Sinaga
//
// Menguji penggunaan kelas eksepsi buatan
//
//****************************************************************
import javax.swing.*;

public class TestBilangan7
{
	public static void main (String args[])
	{
		Bilangan7 b7;

		String strIdx = JOptionPane.showInputDialog(null, "Masukkan Indeks");
		int idx = Integer.parseInt(strIdx);

		b7 = new Bilangan7(idx);

		try {
			b7.check();
		}

		catch (IllegalInputException e)
		{
			System.out.println(e);
		}

		System.out.println("Selesai ...");
	}
}
