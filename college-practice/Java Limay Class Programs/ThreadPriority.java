class Ticker implements Runnable
{
	int count;
	Thread t;
	Boolean flg;
	Ticker(int p)
	{
		t=new Thread(this);
		t.setPriority(p);
		flg=true;
		count=0;
	}
	void Start()
	{
		t.start();
	}
	void Stop()
	{
		t.stop();
	}
	public void run()
	{
		while(flg)
		{
			count++;
		}
	}
}

class ThreadPriority 
{
	public static void main(String []args)
	{
		System.out.println("main starts");
		Ticker t1=new Ticker(2);
		Ticker t2=new Ticker(5);
		Ticker t3=new Ticker(8);

		t1.Start();
		t2.Start();
		t3.Start();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e){}

		t1.Stop();
		t2.Stop();
		t3.Stop();

		System.out.println("\nt1:"+t1.count+"\nt2:"+t2.count+"\nt3:"+t3.count);
		try
		{
			//t1.join();
			//t2.join();
			//t3.join();
		}
		catch(Exception e){}
		System.out.println("main ends");
	}
}