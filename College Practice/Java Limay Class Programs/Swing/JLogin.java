import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mypkg.Util;
import java.util.*;
import java.io.*;

class Mypan extends JDialog implements ActionListener
{
	String a,b;
	JLabel j;
	JButton jj;
	Mypan x;
	Mypan()
	{
		super();
		
		j=new JLabel("Successful\n ");
		jj=new JButton("Back");
		setLayout(null);
		j.setBounds(200,200,100,100);
		

		jj.addActionListener(this);
		jj.setBounds(200,400,100,100);
		add(j);
		add(jj);

		setSize(500,500);
		setVisible(false);
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton d=(JButton)e.getSource();
		if(d==jj)
			setVisible(false);

	}
}

class  JLogin extends JFrame implements FocusListener,ActionListener
{
	JLabel lid,lpd,rlpd;
	JTextField tid;
	JPasswordField tpd;
	JButton bok,bn,be;
	Mypan pan;
	String oldpd,pd;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	FileInputStream fis;
	FileOutputStream fos;
	LinkedList <String>ls;
	int fg,ffg;
	JLogin()
	{
		super("Login");
		ls=new LinkedList();
		lid=new JLabel("ID:");
		lpd=new JLabel("Password");
		rlpd=new JLabel("Reenter Password");
		tid=new JTextField(10);
		tpd=new JPasswordField(10);

		tid.addFocusListener(this);
		tpd.addFocusListener(this);

		bok=new JButton("OK");
		bn=new JButton("New");
		be=new JButton("Exit");

		bok.addActionListener(this);
		bn.addActionListener(this);
		be.addActionListener(this);


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Open();
		setLayout(null);

		lid.setBounds(50,50,100,50);
		tid.setBounds(200,50,100,50);
		lpd.setBounds(50,150,100,50);
		rlpd.setBounds(50,150,100,50);
		tpd.setBounds(200,150,100,50);
		bok.setBounds(50,250,70,20);
		bn.setBounds(140,250,70,20);
		be.setBounds(230,250,70,20);

		add(lid);
		add(tid);
		add(lpd);
		add(tpd);
		add(bok);
		add(bn);
		add(be);

		//pan=new Mypan("","");
		pan=new Mypan();
		setVisible(true);
		setSize(350,350);
		fg=0;
		ffg=0;
	}
	public boolean pdmatch(String sk)
	{
		if(sk.length()<5)
			return false;
		int i=0,n=sk.length(),ac=0,dc=0,oc=0;

		while(i<n)
		{
			char ch=sk.charAt(i);
			if((ch>=65&&ch<=90)||(ch>=97&&ch<=122))
				ac++;
			else
			{
				if(ch>=48&&ch<=57)
					dc++;
				else
					oc++;
			}
			i++;
		}


		return (ac!=0&&dc!=0&&oc!=0);
	}
	public boolean idmatch(String i)
	{	
		try
		{
			int x=Integer.parseInt(i);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;

	}
	public void focusGained(FocusEvent e)
	{
	}
	public void focusLost(FocusEvent e)
	{

		JTextField t=(JTextField)e.getSource();
		if(t==tid)
		{
			String ii=tid.getText();
			if(!idmatch(ii))
			{
				JOptionPane.showMessageDialog(null,"ID should be numeric");
				tid.setText("");
				tid.requestFocus();
			}
			
		}
		//JPasswordField pp=(JPasswordField)e.getSource();
		if(t==tpd)
		{
			if(fg==1)
			{
				if(oldpd!=pd)
				{
					JOptionPane.showMessageDialog(null,"Password Not matching");
					tid.requestFocus();
				}

			}
			else
			{
			String jj=(String)tpd.getText();
			if(!pdmatch(jj))
			{	
				JOptionPane.showMessageDialog(null,"Password should contain at least 1 char ,1 digit with minimum length 6");
				tpd.requestFocus();

			}
		}

		}

	}
	public boolean Check(String id,String ps)
	{
		
		int n=ls.size(),i=0,j=0,flg=0;
		while(i<n)
		{
			if(ls.get(i)==id)
			{
				flg=1;
				while(j<n)
				{
					if(ls.get(i)==ps)
						flg++;
					j++;
				}
			}
			i++;
		}
		if(flg==2)
			return true;
		return false;
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton bb=(JButton)e.getSource();
		if(bb==be)
			System.exit(0);
		if(bb==bok)
		{
			
			String id=tid.getText();
			String pd=tpd.getText();
			//pan=new Mypan(id,pd);
			if(Check(id,pd))
				pan.setVisible(true);
			else
			{
				JOptionPane.showMessageDialog(null,"UserId or Password is Wrong!!");
				tid.setText("");
				tpd.setText("");
				tid.requestFocus();
			}
			if(ffg==1)
			{	JOptionPane.showMessageDialog(null,"Saved");
				tid.setText("");
				tpd.setText("");
				tid.requestFocus();
			}
			
		}
		if(bb==bn)
		{
			Save();
			String id=tid.getText();
			oldpd=tpd.getText();
			fg=1;
			ffg=1;
			remove(lpd);
			add(rlpd);
			tpd.setText("");
			
		}
		SwingUtilities.updateComponentTreeUI(getContentPane());

	}
	public void Save()
	{
		try
		{
			String id=tid.getText();
			pd=tpd.getText();
			ls.add(id);
			ls.add(pd);
			fos=new FileOutputStream("log.dat");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(ls);
			//oos.writeObject(pd);
			ois.close();
			fos.close();
		}
		catch(Exception ee){}

	}
	public void Open()
	{
		try
		{
			fis=new FileInputStream("log.dat");
			ois=new ObjectInputStream(fis);
			ls=new LinkedList<String>();
			ls=(LinkedList<String>)ois.readObject();
			ois.close();
			fis.close();
		}		
		catch(Exception ee)
		{
			ls=new LinkedList<String>();
			return;
		}
	}
	public static void main(String []args)
	{
		JLogin x=new JLogin();
	}
}	