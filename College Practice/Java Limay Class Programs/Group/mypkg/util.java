package mypkg;
import javax.swing.*;

public class util
{
	public static void display(String s)
	{
		JOptionPane.showMessageDialog(null,s);
	}
	public static int iInput(String s)
	{
		int no=0;
		try
		{
			no=Integer.parseInt(JOptionPane.showInputDialog(null,s));
		}
		catch(Exception e)
		{
		}
		return no;
	}
	public static double dInput(String s)
	{
		double no=0.0;
		try
		{
			no=Double.parseDouble(JOptionPane.showInputDialog(null,s));
		}
		catch(Exception e)
		{
		}
		return no;
	}
	public static String sInput(String s)
	{
		return JOptionPane.showInputDialog(null,s);
	}
	public static int iQuery(String a)
	{
		int s=0;
		try
		{
		s=JOptionPane.showConfirmDialog(null,a);
		}
		catch(Exception e){}
		return s;
	}
	public static int iOption(String []opt,String msg,String title)
	{
		int res=0;
		try
		{
			res=JOptionPane.showOptionDialog(null,msg,title,JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,opt,0);
		}
		catch(Exception e)
		{
		}
		return res;
	}
	public static int confirmInput(String msg,String title)
	{
		return JOptionPane.showConfirmDialog(null,msg,title,JOptionPane.YES_NO_OPTION);
	}
}