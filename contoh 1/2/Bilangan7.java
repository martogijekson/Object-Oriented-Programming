//****************************************************************
// Program 9.8
// Bilangan7.java
// Penulis : Benyamin L Sinaga
//
// Menyatakan sebuah kelas yang menunjukkan penggunaan eksepsi
// buatan
//****************************************************************

public class Bilangan7
{
	// indeks di array
	int idx;
	int array[]={0,2,5,7,8};

	public Bilangan7(int bil)
	{
		idx = bil;
	}

	public void check() throws IllegalInputException
	{
		// Jika indeks negatif eksepsi di lemparkan
		// Penangkapan dilakukan oleh fungsi pemanggil di kelas
		// TestBilangan7
		if (idx < 0)
			throw new IllegalInputException("Bil Negatif Tidak Boleh");

		System.out.println("Indeks : " + idx + " : " + array[idx]);
	}
}
