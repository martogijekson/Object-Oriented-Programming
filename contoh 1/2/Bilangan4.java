//****************************************************************
// Program 9.4
// Bilangan4.java
// Penulis : Benyamin L Sinaga
//
// Menyatakan sebuah kelas yang menunjukkan penanganan eksepsi
// dengan lebih dari satu blok catch
//****************************************************************
public class Bilangan4
{
	public static void main (String args[])
	{
		int array[]={0,2,5};

		try {
			System.out.println("Hasil Pembagian   : " + array[2]/array[0]);
			System.out.println("Hasil Penjumlahan : " + array[3]+array[0]);
		}
		catch (ArithmeticException e)
		{
			System.out.println("Pembagian dengan nol ...");
		}

		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("elemen tidak ada ....");
		}

		System.out.println("Selesai ...");
	}
}
