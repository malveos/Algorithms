class AShared
{
	void table(int n)
	{
		System.out.println("Table");
		for (int i=0;i<10;i++)
		System.out.println(" "+n*i);

	}
	
}
class Thrd8 extends Thread
{
	AShared oj;int f;
	Thrd8(String nm,AShared oj)
	{
		super(nm);
		this.oj=oj;
		
		start();
	}
	public void run()
	{
		synchronized(oj)
		{	oj.table((int)(Math.random()*100));
		}
	}
}
class Thrd8App
{
	public static void main(String []args)
	{
		AShared a=new AShared();
		System.out.println("Main startss");
		Thrd8 b=new Thrd8("A",a);
		Thrd8 c=new Thrd8("B",a);
		try
		{
			b.join();
			c.join();
		}
		catch(Exception ew){}
		System.out.println("Main Ends");
	}
}