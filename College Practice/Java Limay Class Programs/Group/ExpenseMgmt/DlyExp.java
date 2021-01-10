package ExpenseMgmt;
//import mypkg.util;
import java.io.*;
public class DlyExp implements Serializable
{
	int d,m,y,fid,amt,eid;
	String enm,fnm,tdate,desc;
	boolean isExpenses;//true:Expense,false:Income
	public DlyExp(int d,int m,int y,int fid,int eid,int amt,String desc,boolean isExpenses,String enm,String fnm)
	{
		this.d=d; this.m=m; this.y=y; this.amt=amt; this.eid=eid; this.fid=fid; this.desc=desc; this.enm=enm; this.fnm=fnm; this.isExpenses=isExpenses;
		tdate=new String(""+d+"/"+m+"/"+y);
	}
	public String toString()
	{
		String s="\nTransaction date:"+tdate+"\nType:"+((isExpenses)?"Expense":"Income")+"\nFamily id:"+fid+"\nMember Name:"+fnm;
		if(isExpenses)
			s=s+"\nExpenses id"+eid+"\nExpense Head:"+enm+"\nExpense AMt:"+amt;
		else
			s=s+"\nIncome amt:"+amt;
		s=s+"\nTransaction details:"+desc;
		return s;
	}
}