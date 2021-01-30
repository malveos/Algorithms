import java.awt.*;
import java.awt.event.*;

class Thrd2 implements Runnable
{
	int n;
	Thrd2(int n)
	{
		this.n=n;
	}
	public void run()
	{
		int i=1;
		System.out.println("Table");
		while(i<n)
		{
			System.out.println(n*i++);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e2)
			{}


		}
	}

}
class Thrd2App 
{
	public static void main(String args[])
	{
		Thrd2 a=new Thrd2(15);
		Thread th=new Thread(a);
		System.out.println("Main Starts");
		th.start();
		try
		{
			th.join();
		}
		catch(Exception eee){}
		System.out.println("Main Ends");
	}
}