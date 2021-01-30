class Shared
{
	synchronized void table(int n)
	{
		System.out.println("Table");
		for (int i=0;i<10;i++)
		System.out.println(" "+n*i);

	}
	synchronized void fibo(int ss)
	{
		int a=-1,b=1,c;
		while(true)
		{
			c=a+b;
			if(c>ss)
				break;
			System.out.println(" "+c);
			a=b;b=c;
		}
	}
}
class Thrd7 extends Thread
{
	Shared a;int f;
	Thrd7(String nm,Shared oj,int f)
	{
		super(nm);
		a=oj;
		this.f=f;
		start();
	}
	public void run()
	{
		if(f==0)
			a.table((int)(Math.random()*100));
		else
			a.fibo(100);
	}
}
class Thrd7App
{
	public static void main(String []args)
	{
		Shared a=new Shared();
		System.out.println("Main startss");
		Thrd7 b=new Thrd7("A",a,0);
		Thrd7 c=new Thrd7("B",a,1);
		try
		{
			b.join();
			c.join();
		}
		catch(Exception ew){}
		System.out.println("Main Ends");
	}
}