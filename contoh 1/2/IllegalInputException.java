//****************************************************************
// Program 9.7
// IllegalInputException.java
// Penulis : Benyamin L Sinaga
//
// Menyatakan sebuah kelas eksepsi buatan
//
//****************************************************************

public class IllegalInputException extends Exception
{
	// konstruktor default
	public IllegalInputException (){}

	public IllegalInputException (String s)
	{
		super(s);
	}
}



