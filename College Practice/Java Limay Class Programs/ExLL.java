import java.util.*;
import mypkg.Util;
import javax.swing.*;

class Account
{
	int acno; 
	boolean state;
	int opnbal;
	String acnm;
	Account()
	{
		acno=opnbal=0;
		state=true;
		acnm=new String();
	}
	void setData(int n)
	{
		acno=n;
		acnm=Util.sInput("Name:");
		opnbal=Util.iInput("Opening balacee");
		state=true;
	}
	public String toString()
	{
		String s="\nAcc Details\nAcc no:"+acno+"\nName:"+acnm+"\nState:"+state+"\nOPening bal:"+opnbal;
		return s;
	}
	
	void display()
	{
		Util.display(toString());
	}
	int getACNO(){return acno;}
	int getOPENBAL(){return opnbal;}
	String getACNM(){return acnm;}
	boolean getSTATE(){return state;}
	
	void deleteRecord()
	{
		state=false;
	}
} 

class AccountTransaction extends Account
{
	LinkedList<Integer> LS;
	AccountTransaction()
	{
		super();
		LS=new LinkedList<Integer>();
	}
	
	public String toString()
	{
			String s=super.toString()+"\nTransactions"+LS+"\nClosing bai:"+calculateBal();
			return s;
	}
	void display()
	{
		Util.display(toString());
	}
	int calculateBal()
	{
		int tot=opnbal;
		for(int amt:LS)
			tot+=amt;
		return tot;
	}
	void deposite(int amt){LS.add(amt); }
	void withDraw(int amt)
	{
		int bal=calculateBal()-500;
		if(amt<bal)
			LS.add(-amt);
	}
}

class AccountList extends LinkedList
{
	AccountTransaction aref;
	AccountList()
	{
		super();aref=null;
		
	}
	int search(int acno)
	{
		int i=0,n=size();
		while(i<n)
		{
			aref=(AccountTransaction)get(i);
			if(aref.getACNO()==acno)
				break;
			i++;
			
		}
		
		if(i==n)
		{
			aref=null;
			return -1;
		}
		else
			return i;
	}
	
	void add()
	{
		int no=0;
		try
		{
			no=Integer.parseInt(JOptionPane.showInputDialog(null,"enter acno:"));
		}
		catch(Exception e){return;}
		
		int pos=search(no);
		if(pos>=0)
		{
			Util.display("Exists");
			return;
		}
		aref=new AccountTransaction();
		aref.setData(no);
		add(aref);
	}
	void mod()
	{
		int no=0;
		try
		{
			no=Integer.parseInt(JOptionPane.showInputDialog(null,"enter acno:"));
		}
		catch(Exception e){return;}
		
		int pos=search(no);
		if((pos==-1)||(aref.getSTATE()==false))
		{
			Util.display("Invalid info");
			return;
		}
		
		aref.setData(no);
		
	}
	void delete()
	{
		int no=0;
		try
		{
			no=Integer.parseInt(JOptionPane.showInputDialog(null,"enter acno:"));
		}
		catch(Exception e){return;}
		
		int pos=search(no);
		if((pos==-1)||(aref.getSTATE()==false))
		{
			Util.display("Invalid info");
			return;
		}
		
		aref.LS.add(-1*aref.calculateBal());
		aref.deleteRecord();
		
	}
	void deposite()
	{
		
		int no=0;
		try
		{
			no=Integer.parseInt(JOptionPane.showInputDialog(null,"enter acno:"));
		}
		catch(Exception e){return;}
		
		int pos=search(no);
		if((pos==-1)||(aref.getSTATE()==false))
		{
			Util.display("Invalid info");
			return;
		}
		int amt=0;
		try
		{
			amt=Integer.parseInt(JOptionPane.showInputDialog(null,"enter amount:"));
		}
		catch(Exception e){return;}
		if(amt<=0)
		{
			Util.display("Invalid Transaction!!");
			return;
		}
		
		aref.deposite(amt);
		
	
	}
	void withDraw()
	{
		int no=0;
		try
		{
			no=Integer.parseInt(JOptionPane.showInputDialog(null,"enter acno:"));
		}
		catch(Exception e){return;}
		
		int pos=search(no);
		if((pos==-1)||(aref.getSTATE()==false))
		{
			Util.display("Invalid info");
			return;
		}
		int amt=0;
		try
		{
			amt=Integer.parseInt(JOptionPane.showInputDialog(null,"enter amount:"));
		}
		catch(Exception e){return;}
		if(amt<=0)
		{
			Util.display("Invalid Transaction!!");
			return;
		}
		aref.withDraw(amt);
	}
	void display()
	{
		int i=0,n=size();
		while(i<n)
		{
			aref=(AccountTransaction)get(i);
			aref.display();
			i++;
		}
	}
	void menu()
	{
		while(true)
		{	
			String []option={"add","mod","delete","deposite","withDraw","display","Exit"};
			int opt=Util.iOption("Accounts",option);
			if(opt==6)
				break;
			switch(opt)
			{
				case 0:
						add();break;
				case 1:
						mod();break;
				case 2:
						delete();break;
				case 3:
						deposite();
						break;
				case 4:
						withDraw();break;
				case 5:
						display();break;
			}
		}	
	}
}

class ExLL
{
	
	
	public static void main(String []args)
	{
		AccountList obj=new AccountList();
		obj.menu();
	}
}