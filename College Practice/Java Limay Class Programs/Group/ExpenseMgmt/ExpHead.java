package ExpenseMgmt;
import mypkg.*;
import java.io.*;
import javax.swing.*;
public class ExpHead implements Serializable
{
	int eid;
	String enm;
	public boolean estate;
	public ExpHead()
	{
		eid=0;
		enm=new String();
		estate=true;
	}
	public void set(int n)
	{
		eid=n;
		enm=util.sInput("Enter Expense name:");
		estate=true;
	}
	public String toString()
	{
		String s="\nExpense Details\nID:"+eid+"\nExpense Name:"+enm+"\n Expense state:"+estate;
		return s;
	}
	public void display()	
	{
		util.display(toString());
	}
	public String getName()	
	{
		return enm;
	}	
	public int getID()
	{
		return eid;
	}
	public boolean getState()
	{return estate;}
				
}
			