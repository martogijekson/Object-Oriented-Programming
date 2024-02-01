class WithExceptionHandling{
	public static void main(String[] args){
		int a,b;  float r;
		a = 7;   b = 0;
		try{
			r = a/b;
			System.out.println("Result is " + r);
		}
		catch(ArithmeticException e){
			System.out.println("Error..");
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception dc){
			dc.printStackTrace();
		}
		finally{
			System.out.println("Selesai..");
		}
        System.out.println("Program reached this line");
	}
}
