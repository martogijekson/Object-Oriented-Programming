//****************************************************************
// Program 9.2
// Bilangan2.java
// Penulis : Benyamin L Sinaga
//
// Menyatakan sebuah kelas yang mengimplementasi pembagian
// antara dua bilangan. Menunjukkan penanganan eksepsi
//****************************************************************
public class Bilangan2
{
	public static void main (String args[])
	{
		int bilPenyebut = 5;
		int bilPembagi  = 0;

		try {
			System.out.println("Hasil Pembagian " + bilPenyebut/bilPembagi);
		}
		catch (ArithmeticException e)
		{
			System.out.println("Pembagian dengan nol ...");
		}
		System.out.println("Selesai ...");

	}
}
