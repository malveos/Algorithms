import java.awt.*;
import java.awt.event.*;

class Thrd1 extends Thread
{
	int no;
	String nm;
	Thrd1(String tnm, int n)
	{
		super(tnm);
		nm=tnm;
		no=n;
		start();
	}
	public void run()
	{
			int i=1;
			while(i<no)
			{
				System.out.println("Thread"+nm+" "+i);
				try
				{
					Thread.sleep(1000);
				}
				catch(Exception e){}
				i++;
			}
	}
	public static void main(String []args)
	{
		System.out.println("Main method");
		Thrd1 a,b,c;
		a=new Thrd1("A",5);
		b=new Thrd1("B",10);
		c=new Thrd1("C",15);
		System.out.println("Main method");

	}
}