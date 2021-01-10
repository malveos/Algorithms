package ExpenseMgmt;
import mypkg.util;
import java.io.*;
import java.util.*;
import javax.swing.*;
import ExpenseMgmt.ExpHead;
import ExpenseMgmt.ExpHeadAMD;
import ExpenseMgmt.Family;
import ExpenseMgmt.FamilyAMD;
import ExpenseMgmt.DlyExp;

public class Munimji
{
	ExpHeadAMD els;
	FamilyAMD  fls;
	DlyExp eobj;
	LinkedList<DlyExp>tls;
	public Munimji()
	{
		els=new ExpHeadAMD();
		fls=new FamilyAMD();
		tls=new LinkedList<DlyExp>();
		open();
	}
	public void open()
	{
		els.eOpen();
		fls.fOpen();
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try
		{
			fis=new FileInputStream("DlyExp.dat");
			ois=new ObjectInputStream(fis);
			tls=(LinkedList<DlyExp>)ois.readObject();
			ois.close();
			fis.close();
		}
		catch(Exception e){}
	}
	
	public void save()
	{
		els.eSave();
		fls.fSave();
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try
		{
			fos=new FileOutputStream("DlyExp.dat");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(tls);
			oos.close();fos.close();
		}
		catch(Exception e){}
	}
	
	public void addExpenses()
	{
		int d=0,m=0,y=0,eid=0,fid=0,amt=0;
		String enm="",fnm="",desc="";
		d=util.iInput("Day");
		m=util.iInput("month");
		y=util.iInput("Year");
		fid=util.iInput("Family id");
		if(fls.fSearch(fid)==false)
		{
			util.display("Invalid id");
			return;
		}
		fnm=fls.fref.getName();
		eid=util.iInput("Expense id");
		if(els.eSearch(eid)==false)
		{
			util.display("Invalid id");
			return;
		}
		enm=els.eref.getName();
		amt=util.iInput("Amount::");
		if(amt<0)
		{
			util.display("invalid amt");
			return;
		}
		desc=util.sInput("Transaction details");
		DlyExp p=new DlyExp(d,m,y,fid,eid,amt,desc,true,enm,fnm);
		tls.add(p);
	}
	
	public void addIncome()
	{
		int d=0,m=0,y=0,eid=0,fid=0,amt=0;
		String enm="",fnm="",desc="";
		d=util.iInput("Day");
		m=util.iInput("month");
		y=util.iInput("Year");
		fid=util.iInput("Family id");
		if(fls.fSearch(fid)==false)
		{
			util.display("Invalid id");
			return;
		}
		fnm=fls.fref.getName();
		eid=0;
		enm="";
		amt=util.iInput("Amount::");
		if(amt<0)
		{
			util.display("invalid amt");
			return;
		}
		desc=util.sInput("Transaction details");
		DlyExp p=new DlyExp(d,m,y,fid,eid,amt,desc,false,enm,fnm);
		tls.add(p);
	}
	public void display()
	{
		int itot=0,m=0,y=0,tot=0;
		boolean type=true;
		int res=util.iQuery("expenses disply");
		if(res==JOptionPane.YES_OPTION)
			type=true;
		else
			type=false;
		m=util.iInput("month");
		y=util.iInput("Year");
		for(DlyExp obj:tls)
		{
			if(obj.isExpenses==type)
			{
				if(obj.m==m&&obj.y==y)
				{
					util.display(obj.toString());
					tot+=obj.amt;
				}
			}
		}
		util.display(((type)?"Expense":"Income")+"\nTotal:"+tot);
	}
	public void menu()
	{
		String option[]={"open","Family Master","Exp Master","Dly Expense","Income","Save","Display","exit"};
		int opt=0;
		while(true)
		{
			opt=util.iOption(option,"Menu","Munimji");
			if(opt==7)
				break;
			switch(opt)
			{
				case 0:
						open();break;
				case 1:fls.fMenu();break;
				case 2:els.eMenu();break;
				case 3:addExpenses();break;
				case 4:addIncome();break;
				case 5:save();break;
				case 6:display();break;
				
			}
		}
	}
}