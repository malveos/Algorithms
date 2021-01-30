import javax.swing.*;
abstract class Array
{
	int []arr;
	Array()
	{
		arr=new int[5];
	}
	
	void set(int pos,int d)
	{
		arr[pos]=d;
	}
	int get(int pos)
	{
		return arr[pos];
	}
	
	public String toString()
	{
		return new String("Data");
	}
	abstract void menu();
}

class Stack extends Array
{
	int top;
	Stack(){super();top=-1;}
	
	void push(int d)
	{
		if(top==arr.length-1)
		{
			JOptionPane.showMessageDialog(null,"overflow");
			return;
		}
		set(++top,d);
	}
	void pop()
	{
		if(top==-1)
		{
			JOptionPane.showMessageDialog(null,"underflow");
			return;
		}
		
		--top;
	}
	
	
	public String toString()
	{
		String s="Stack\n";
		if(top==-1)
			s+=" "+"is emty";
		else
		{
			for(int i=top;i>=0;i--)
				s+=""+get(i);
		}
		
		return s;
	}
	
	void display()
	{
		JOptionPane.showMessageDialog(null,toString());
	}
	
	void menu()
	{
		String []option={"push","pop","display","exit"};
		int opt=0,d=0;
		while(true)
		{
			try
			{
				opt=JOptionPane.showOptionDialog(null,"choose","Stack",JOptionPane.YES_OPTION,JOptionPane.PLAIN_MESSAGE,null,option,0);
			}
			catch(Exception e){}
			if(opt==3)
				break;
			switch(opt)
			{
				case 0:try{
					d=Integer.parseInt(JOptionPane.showInputDialog(null,"Data"));
					}
					catch(Exception e){continue;}
					push(d);break;
					
				case 1:
						pop();break;
				case 2:
						display(); break;
			}
		}
	}
	
}
class Queue extends Stack
{
	int fr,rr;
	Queue(){super();rr=-1;fr=0;}
	
	void insert(int d)
	{
		if(rr==arr.length-1)
		{
			JOptionPane.showMessageDialog(null,"overflow");
			return;
		}
		set(++rr,d);
	}
	void remove()
	{
		if(rr<fr)
		{
			JOptionPane.showMessageDialog(null,"underflow");
			return;
		}
		
		++fr;
	}
	
	
	public String toString()
	{
		String s="Queue\n";
		if(rr<fr)
			s+=""+"is emty";
		else
		{
			for(int i=fr;i<rr;i++)
				s+=" "+get(i);
		}
		
		return s;
	}
	
	void display()
	{
		JOptionPane.showMessageDialog(null,toString());
	}
	
	void menu()
	{
		String []option={"insert","remove","display","exit"};
		int opt=0,d=0;
		while(true)
		{
			try
			{
				opt=JOptionPane.showOptionDialog(null,"choose","Queue",JOptionPane.YES_OPTION,JOptionPane.PLAIN_MESSAGE,null,option,0);
			}
			catch(Exception e){}
			if(opt==3)
				break;
			switch(opt)
			{
				case 0:try{
					d=Integer.parseInt(JOptionPane.showInputDialog(null,"Data"));
					}
					catch(Exception e){continue;}
					insert(d);break;
					
				case 1:
						remove();break;
				case 2:
						display(); break;
			}
		}
	}
	
}

class DS
{
	public static void main(String []args)
	{
		String []option={"Stack","Queue","Exit"};
		
		int opt=0;
		Array ref=null;
		try
		{
			opt=JOptionPane.showOptionDialog(null,"choose","Data Structure",JOptionPane.YES_OPTION,JOptionPane.PLAIN_MESSAGE,null,option,0);
		}
		catch(Exception e){return;}
		if(opt==2)
			return;
		if(opt==0)
			ref=new Stack();
		else
			ref=new Queue();
		
		ref.menu();
	}
}