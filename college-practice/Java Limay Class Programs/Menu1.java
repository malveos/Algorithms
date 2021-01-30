import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
class Menu1 extends Frame implements ActionListener
{
	MenuBar mb;
	Menu mf,me,mx;
	MenuItem inew,iopen,iclose,isave;
	MenuItem icut,icopy,ipaste;
	MenuItem iys,ino;
	Menu1()
	{
		super();
		inew=new MenuItem("New");
		iopen=new MenuItem("Open");
		iclose=new MenuItem("Close");
		isave=new MenuItem("Save");

		icut=new MenuItem("Cut");
		icopy=new MenuItem("Copy");
		ipaste=new MenuItem("Paste");

		iys=new MenuItem("Yes");
		ino=new MenuItem("No");

		inew.addActionListener(this);
		iopen.addActionListener(this);
		iclose.addActionListener(this);
		isave.addActionListener(this);
		icut.addActionListener(this);
		icopy.addActionListener(this);
		ipaste.addActionListener(this);
		iys.addActionListener(this);
		ino.addActionListener(this);

		mf=new Menu("File");
		mf.add(inew);
		mf.add(iopen);
		mf.add(isave);
		mf.add(iclose);

		me=new Menu("Edit");
		me.add(icut);
		me.add(icopy);
		me.add(ipaste);

		mx=new Menu("Exit");
		mx.add(ino);
		mx.add(iys);


		mb=new MenuBar();
		mb.add(mf);
		mb.add(me);
		mb.add(mx);

		setMenuBar(mb);
		setSize(500,500);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		MenuItem p=(MenuItem)e.getSource();
		if(p==iys)
			System.exit(0);
		 else
			System.out.println(e.getActionCommand());
	}
	public static void main(String []args)
	{
		Menu1 a=new Menu1();
	}
}