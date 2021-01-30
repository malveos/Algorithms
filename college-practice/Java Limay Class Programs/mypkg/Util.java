package mypkg;
import javax.swing.*;

public class Util
{
	public static void display(String s)
	{
		JOptionPane.showMessageDialog(null,s);
	}
	public static int iInput(String s)
	{
		int d=0;
		try
		{
			d=Integer.parseInt(JOptionPane.showInputDialog(null,s));
		}
		catch(Exception e){}
		return d;
	}
	public static double dInput(String s)
	{
		double d=0.0;
		try
		{
			d=Double.parseDouble(JOptionPane.showInputDialog(null,s));
		}
		catch(Exception e){}
		return d;
	}
	public static String sInput(String s)
	{
		String d="";
		try
		{
			d=(JOptionPane.showInputDialog(null,s));
		}
		catch(Exception e){}
		return d;
	}
	public static int iQuery(String s)
	{
		int d=0;
		try
		{
			d=(JOptionPane.showConfirmDialog(null,s));
		}
		catch(Exception e){}
		return d;
	}
	public static int iOption(String s,String []t)
	{
		int d=0;
		try
		{
			d=JOptionPane.showOptionDialog(null,"Choose option",s,JOptionPane.YES_OPTION,JOptionPane.PLAIN_MESSAGE,null,t,0);
		}
		catch(Exception e){}
		return d;
	}
	
}