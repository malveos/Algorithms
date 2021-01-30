import mypkg.Util;
import java.util.*;
import javax.swing.*;

class stu implements Comparable<stu>
{
	int no;String nm;
	stu()
	{no=0;nm="";}
	stu(int a,String b)
	{no=a;nm=b;}
	
	public String toString()
	{
		String s="\nRoll no:"+no+"\nName:"+nm;
		return s;
	}
	
	public int compareTo(stu a)
	{
		return nm.compareTo(a.nm);
	}
	
	public void display()
	{
		Util.display(toString());
	}
	public boolean equals(Object obj)
	{
		return true;
	}
	
}

class UseArrayList1
{
	public static void main(String []args)
	{
		stu[]a={new stu(1,"ram"),new stu(2,"wina"),new stu(3,"param"),new stu(4,"shailesh"),new stu(5,"kapoor")};
		int i=0,n=a.length;
		String nm="";
		/*
		Util.display("before sorting");
		while(i<n)
		{
			a[i].display();
			i++;
			
		}
		Arrays.sort(a);
		Util.display("After sorting");
		for(i=0;i<n;i++)
			a[i].display();
		
		Util.display("Other method is...........................\n");*/
		ArrayList<stu>b=new ArrayList<stu>();
		while(true)
		{
			try
			{
				n=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter roll no"));
				nm=JOptionPane.showInputDialog(null,"name");
			}
		catch(Exception e){continue;}
			
			
			stu k=new stu(n,nm);
			b.add(k);
			
			int res=JOptionPane.showConfirmDialog(null,"continue?");
			if(res==JOptionPane.NO_OPTION)
				break;
			
		}
			Util.display("before sorting");
		for(stu m:b)
			m.display();
		
		stu []ref=new stu[b.size()];
		ref=b.toArray(ref);
	
		Util.display("After sorting");
		Arrays.sort(ref);
		for(stu m:ref)
			m.display();
		
	}
}