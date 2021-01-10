package ExpenseMgmt;
import mypkg.util;
import ExpenseMgmt.Family;
import ExpenseMgmt.ExpHead;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class ExpHeadAMD  
{
	LinkedList<ExpHead> fam;
	ExpHead eref;
	public ExpHeadAMD()
	{
		fam =new LinkedList<ExpHead>();
	}
	
	public boolean eSearch(int eid)
	{
		
		int i=0,n=fam.size();
		while(i<n)	
		{
			eref=fam.get(i);	
			if(eref.getID()==eid)
				break;
			i++;
		}
		if(i==n)
		{	
			eref=null;
			return false;
		}
		return true;
	}
	public void eAdd()
	{
		int eid=util.iInput("Enter Expense ID:");
		if(eSearch(eid)==true)
		{
			util.display("Id  already exists:");
			return;
		}
		eref=new ExpHead();
		eref.set(eid);
		fam.add(eref);
		
	}		
	public void eMod()
	{	
		int eid=util.iInput("Enter Expense ID:");
		if(eSearch(eid)==false)
		{
			util.display("record not exists:");
			return;
		}
		eref.set(eid);			
	}
	public void eDisplay()	
	{	
		int i=0,n=fam.size();		
		while(i<n)
		{	
			eref=fam.get(i);
			eref.display();
			i++;
		}
	}	
	public void eOpen()
	{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try
		{	
			fis=new FileInputStream("exp.dat");
			ois=new ObjectInputStream(fis);
			fam=(LinkedList)ois.readObject();
			ois.close();
			fis.close();	
		}
		catch(Exception e){}
	}
	public void eSave()
	{
		FileOutputStream fis=null;
		ObjectOutputStream ois=null;
		try
		{	
			fis=new FileOutputStream("exp.dat");
			ois=new ObjectOutputStream(fis);
			ois.writeObject(fam);
			ois.close();
			fis.close();	
		}
		catch(Exception e){}
	}
	
	public void eDel()
	{
		int eid=util.iInput("Enter Id");
		if(eSearch(eid)==false)
		{
			util.display("record not exist");
			return;	
		}
		eref.estate=false;
	}
	public void eMenu()
	{
		String []option={"add","mod","delete","display","Exit"};
		int opt=0;
		while(true)		
		{	
			opt=util.iOption(option,"menu","choose option");
			if(opt==4)
				break;		
			switch(opt)	
			{
				case 0:
				 	eAdd();
					break;
				case 1:
					eMod();
					break;
				
				case 2:
					eDel();
					break;		
				case 3:	
					eDisplay();
					break;
			
			}
		}
	}
	/*public static void main(String []args)
	{
		ExpHeadAMD fm=new ExpHeadAMD();
		fm.eMenu();
	}*/
		
			
}
	