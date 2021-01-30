import java.awt.*;
import java.awt.event.*;
import java.io.*;
import mypkg.Util;
import mypkg.City;
import java.util.*;


class CityGUI extends Frame implements WindowListener,ActionListener,FocusListener
{
	Label ldesc,lid,lnm;
	TextField tid,tnm;
	LinkedList<City>ls=null;
	Button ba,bm,bd,bdis;
	Panel p1,p2;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	FileInputStream fis;
	FileOutputStream fos;
	City cref,tref;
	int id;String nm;
	CityGUI()
	{
		super("City");
		ldesc=new Label("City data");
		lid=new Label("ID");
		lnm=new Label("Name");
		tid=new TextField(60);
		tnm=new TextField(40);
		p1=new Panel();
		p1.setLayout(null);
		
		//cref=new City();
		ldesc.setBounds(50,50,100,20);
		lid.setBounds(50,80,100,20);
		tid.setBounds(160,80,100,20);
		lnm.setBounds(50,110,100,20);
		tnm.setBounds(160,110,100,20);
		ls=new LinkedList<City>();
		p1.add(ldesc);
		p1.add(lid);
		p1.add(tid);
		p1.add(lnm);
		p1.add(tnm);
		
		tid.addFocusListener(this);
		tnm.addFocusListener(this);
		add(p1,BorderLayout.CENTER);
		
		ba=new Button("ADD");
		bm=new Button("MOD");
		bd=new Button("DEL");
		bdis=new Button("Display");
		
		ba.addActionListener(this);
		bm.addActionListener(this);
		bd.addActionListener(this);
		bdis.addActionListener(this);
		
		p2=new Panel();
		p2.add(ba);
		p2.add(bm);
		p2.add(bd);
		p2.add(bdis);
		add(p2,BorderLayout.SOUTH);
		setSize(360,380);
		setVisible(true);
		addWindowListener(this);
	}
	
	public void windowOpened(WindowEvent e){Open();}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e)
	{
		Save();
		System.exit(0);
	}
	void Open()
	{
		try
		{
			fis=new FileInputStream("City.dat");
			ois=new ObjectInputStream(fis);
			ls=new LinkedList<City>();
			ois.readObject();
			ois.close();
			fis.close();
		}
		catch(Exception e)
		{
			if(ls==null)
				ls=new LinkedList<City>();
		}
	}
	void Save()
	{
		try
		{
			fos=new FileOutputStream("City.dat");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(ls);
			oos.close();
			fos.close();
		}
		catch(Exception e){}
	}
	boolean Search(int id)
	{
		int i=0;
		int n=ls.size();
		while(i<n)
		{
			if(cref.getID()==id)
				break;
			i++;
		}
		if(i==n)
			cref=null;
		return(cref!=null);
	}
	boolean Search(String nm)
	{
		int i=0;
		String s="";
		int n=ls.size();
		while(i<n)
		{
			cref=ls.get(i);
			if(cref.getName().equals(nm))
				break;
			i++;
		}
		if(n==0)
			cref=null;
		return(cref!=null&&i<n);
	}
	void Add()
	{
		cref=new City(id,nm);
		ls.add(cref);
	}
	void Mod()
	{
		cref.nm=nm;
	}
	void Del()
	{
		ls.remove(cref);
	}
	void Dis()
	{
		int i=0;
		int n=ls.size();
		while(i<n)
		{
			cref=ls.get(i);
			cref.display();
			i++;
		}
	}
	public void focusGained(FocusEvent e)
	{
		TextField t=(TextField)e.getSource();
		if(t==tid)
		{
			ba.setEnabled(false);
			bm.setEnabled(false);
			bd.setEnabled(false);
		}
	}
	public void focusLost(FocusEvent e)
	{
		TextField t=(TextField)e.getSource();
		if(t==tid)
		{
			try
			{
				id=Integer.parseInt(tid.getText());
			}
			catch(Exception e1)
			{
				tid.requestFocus();
				return;
			}
			tnm.setForeground(Color.black);
			if(Search(id)==true)
			{
				tnm.setText(cref.getName());
				ba.setEnabled(false);
				bm.setEnabled(true);
				bd.setEnabled(true);
				
			}
			else
			{
				tnm.setText("");
				ba.setEnabled(true);
				bm.setEnabled(false);
				bd.setEnabled(false);
			}
			tref=cref;
		}
		else
		{
			nm=tnm.getText();
			if(Search(nm)==true)
			{
				tnm.setForeground(Color.red);
				tnm.requestFocus();
				return;
			}
			if(tref!=cref)
				cref=tref;
		}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==bdis)
			Dis();
		else
		{
			if(b==ba)
				Add();
			if(b==bm)
				Mod();
			if(b==bd)
				Del();
			tid.requestFocus();
		}	
		
	}
	public static void main(String []args)
	{
		CityGUI g=new CityGUI();
	}
}