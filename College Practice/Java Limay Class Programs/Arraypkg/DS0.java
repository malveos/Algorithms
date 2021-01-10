package Arraypkg;
import Arraypkg.IDataIO;
import Arraypkg.IStack;
import Arraypkg.IQueue;
import mypkg.Util;

public class DS0 implements IStack,IDataIO,IQueue
{
	int arr[];
	int fr,rr,top;
	public DS0()
	{
		arr=new int [5];fr=0;rr=-1;top=-1;
	}
	public void set(int pos,int d)
	{
		arr[pos]=d;
	}
	public int get(int pos)
	{      return arr[pos];}
	public void push(int d)
	{
		if(top==arr.length-1)
		{
			Util.display("Overflow");
			return;
		}
		set(++top,d);
	}
	public void pop()
	{
		if(top==-1)
		{
			Util.display("Underflow");
			return;
		}
		top--;
	}
	public void sdisplay()
	{
		String s="\nStack";
		if(top==-1)
			s=s+" is Empty";
		else
		{
			for(int i=top;i>=0;i--)
				s=s+get(i);
		}
		Util.display(s);
	}
	public void smenu()
	{
		String[]opt={"push","pop","display","exit"};
		int d=0,re=0;
		while(true)
		{re=Util.iOption("Stack",opt);
		if(re==3)
			break;
		switch(re)
		{
			case 0:
					d=Util.iInput("Data");
					push(d);
					break;
			case 1:
					pop();break;
			case 2:
					sdisplay();break;
		}
		}
	}
	
	public void insert(int d)
	{
		if(rr==arr.length-1)
		{
			Util.display("Overflow");
			return;
		}
		set(++fr,d);
			
	}
	
	public void remove()
	{
		if(rr<=fr)
		{
			Util.display("Underflow");
			return;
		}
		++fr;
	}
	public void qdisplay()
	{
		String s=" Queue";
		if(rr<fr)
			s+=" is Empty";
		else{
			for(int i=fr;i<=rr;i++)
				s=s+" "+get(i);
			
		}
		Util.display(s);
	}
	
	public void qmenu()
	{
		String []opt={"insert","remove","display","exit"};
		int d,r;
		while(true)
		{
			r=Util.iOption("Queue",opt);
			if(r==3)
				break;
			switch(r)
			{
				case 0:
						d=Util.iInput("Data");
						insert(d);break;
				case 1:
						remove();break;
				case 2:
						qdisplay();break;
			}
		}
	}
	
}

