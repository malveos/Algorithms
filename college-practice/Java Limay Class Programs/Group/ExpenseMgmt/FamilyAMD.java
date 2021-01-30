package ExpenseMgmt;
import mypkg.util;
import ExpenseMgmt.Family;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class FamilyAMD  
{
	LinkedList<Family> fam;
	Family fref;
	public FamilyAMD()
	{
		fam =new LinkedList<Family>();
	}
	
	public boolean fSearch(int id)
	{
		
		int i=0,n=fam.size();
		while(i<n)	
		{
			fref=fam.get(i);	
			if(fref.getID()==id)
				break;
			i++;
		}
		if(i==n)
		{	
			fref=null;
			return false;
		}
		return true;
	}
	public void fAdd()
	{
		int id=util.iInput("Enter Family Member ID:");
		if(fSearch(id)==true)
		{
			util.display("Id  already exists:");
			return;
		}
fref=new Family();
		fref.set(id);
		fam.add(fref);
		
	}		
	public void fMod()
	{	
		int id=util.iInput("Enter Family Member ID:");
		if(fSearch(id)==false)
		{
			util.display("record not exists:");
			return;
		}
		fref.mod(id);			
	}
	public void fDisplay()	
	{	
		int i=0,n=fam.size();		
		while(i<n)
		{	
			fref=fam.get(i);
			fref.display();
			i++;
		}
	}	
	public void fOpen()
	{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try
		{	
			fis=new FileInputStream("fam.dat");
			ois=new ObjectInputStream(fis);
			fam=(LinkedList)ois.readObject();
			ois.close();
			fis.close();	
		}
		catch(Exception e){}
	}
	public void fSave()
	{
		FileOutputStream fis=null;
		ObjectOutputStream ois=null;
		try
		{	
			fis=new FileOutputStream("fam.dat");
			ois=new ObjectOutputStream(fis);
			ois.writeObject(fam);
			ois.close();
			fis.close();	
		}
		catch(Exception e){}
	}
	
	public void fDel()
	{
		int id=util.iInput("Enter Id");
		if(fSearch(id)==false)
		{
			util.display("record not exist");
			return;	
		}
		fref.state=false;
	}
	public void fMenu()
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
				 	fAdd();
					break;
				case 1:
					fMod();
					break;
				
				case 2:
					fDel();
					break;		
				case 3:	
					fDisplay();
					break;
			
			}
		}
	}
	/*public static void main(String []args)
	{
		FamilyAMD fm=new FamilyAMD();
		fm.fMenu();
	}*/
		
			
}
	