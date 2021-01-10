import javax.swing.*;
import mypkg.Util;
interface IDataIO
{
	void setData(int no);
	void display();
}

class City implements IDataIO
{
	int cid;
	String cnm;
	City()
	{
		cid=0;
		cnm="";
	}
	public void setData(int n)
	{
		cid=n;
		cnm=Util.sInput("Nmae of city");
	}
	
	public void display()
	{
		Util.display(toString());
	}
	
	public String toString()
	{
		return new String("\nCity id:"+cid+"\nName:"+cnm);
	}
	
	public static void main(String []args)
	{
		City a=new City();
		a.setData(111);
		a.display();
	}
}