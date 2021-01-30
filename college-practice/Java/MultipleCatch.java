class MultipleCatch{
	public static void main(String []args){
		try{
			System.out.println(12/0);
		}
		catch(ArithmeticException e){
			System.out.println("ArithmaticExpression");
		}
		catch(Exception e){
			System.out.println("General");
		}
	}
}