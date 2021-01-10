class UseExtendNumber<T extends Number>{
	public  T cal(T x){
		System.out.println(x.getClass()+"--");
		return x;
	}
	public static void main(String[] args) {
		UseExtendNumber x=new UseExtendNumber();
		System.out.println("Ans:"+x.cal(10.0));
		System.out.println("Ans:"+x.cal(5));
		System.out.println("Ans:"+x.cal(10f));	
		//System.out.println("Ans:"+x.cal(true));
	}
}