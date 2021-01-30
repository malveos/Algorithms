package ExpenseMgmt;
import mypkg.*;
import java.io.*;
import javax.swing.*;
public class Family implements Serializable
{
	int id;
	String nm;
	int age;
	char mf;
	boolean isHead;
	boolean isEarner;
	public boolean state;
	public Family()
	{
		id=0;
		nm=new String();
		age=0;
		mf='z';
		isHead=isEarner=true;
		state=true;
	}
	public void set(int n)
	{
		id=n;
		nm=util.sInput("Enter name:");
		age=util.iInput("Enter age:");
		int g=1;
		g=util.iInput("Enter 1 for male and 2 for female:");
		if(g==1)
			mf='m';
		else
			mf='f';	
		g=util.iQuery("Is the person family head?:");
		if(g==JOptionPane.YES_OPTION)
			isHead=true;
		else
			isHead=false;
		g=util.iQuery("Is the person earner?:");
		if(g==JOptionPane.YES_OPTION)
			isEarner=true;
		else
			isEarner=false;
		state=true;
	}
	public String toString()
	{
		String s="\nFamily Details\nID:"+id+"\nName:"+nm+"\nAge:"+age+"\nGender:"+mf+"\nIs head:"+isHead+"\nis Earner:"+isEarner+"\n state:"+state;
		return s;
	}
	public void display()	
	{
		util.display(toString());
	}
	public String getName()	
	{
		return nm;
	}	
	public int getID()
	{
		return id;
	}
	public  int getAge()	
	{
		return age;
	}
	public  char getMF()
	{
		return mf;
	}
	public boolean isFamilyHead()
	{
		return isHead;
	}
	public  boolean isFamilyEarner()
	{	
		return isEarner;
	}
	public  void mod(int id)
	{
		int g=0;
		g=util.iQuery("Is the person family head?:");
		if(g==JOptionPane.YES_OPTION)
			isHead=true;
		else
			isHead=false;
		g=util.iQuery("Is the person earner?:");
		if(g==JOptionPane.YES_OPTION)
		{
			isEarner=true;
		}
		else
		{
			isEarner=false;
		}	
	}
	public boolean getState()
	{return state;}

				
}
			