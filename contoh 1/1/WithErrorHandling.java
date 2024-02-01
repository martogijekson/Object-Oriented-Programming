class WithErrorHandling{
	public static void main(String[] args){
		int a,b;
		a = 7; b = 0;
		if (b != 0){
			System.out.println("Result is " + a/b);
		}
		else{
			System.out.println("B is zero");
		}
        System.out.println("Program is complete");
	}
}
