
public class Bilangan
{
	public static void main (String args[])
	{
		int array[]={0,2,5};
		int idx_1, idx_2;

		idx_1 = Integer.parseInt(args[0]);
		idx_2 = Integer.parseInt(args[1]);

		try {
			System.out.println("Hasil Pembagian   : " + array[1]/array[idx_1]);
			System.out.println("Hasil Penjumlahan : " + (array[2]+array[idx_2]));
		}
		catch (Exception e)
		{
			System.out.println("Error ...");
		}

		//catch (ArrayIndexOutOfBoundsException e)
		//{
		//	System.out.println("elemen tidak ada ....");
		//}

		System.out.println("Selesai ...");
	}
}


