import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import mypkg.Shape;
class Mouse4 extends Frame
{
	int x,y,w,h,flg,r,g,b;
	Color cr;
	LinkedList<Shape> ls;
	Shape sobj;
	Mouse4()
	{
		super("draw ovals");
		r=g=b=0;

		ls=new LinkedList<Shape>();
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				Save();
				System.exit(0);
			}
			public void windowOpened(WindowEvent e)
			{
				Open();
				repaint();
			}
			public void windowDeiconified(WindowEvent e)
			{
				repaint();
			}

		});
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				if(flg==0)
				{
					x=e.getX();
					y=e.getY();
					flg=1;
				}
				else
				{
					w=e.getX()-x;
					h=e.getY()-y;
					flg=0;
					r=(int)(Math.random()*255);
					g=(int)(Math.random()*255);
					b=(int)(Math.random()*255);
					cr=new Color(r,g,b);
					sobj=new Shape(x,y,w,h,4,cr);
					
					ls.add(sobj);
					repaint();

				}
			}
		});
		setSize(500,500);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		int i=0,n=ls.size();
		while(i<n)
		{
			sobj=ls.get(i);
			sobj.draw(this);
			i++;
		}
	}
	public void Open()
	{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try
		{
			fis=new FileInputStream("Mypaint.dat");
			ois=new ObjectInputStream(fis);
			ls=(LinkedList<Shape>)ois.readObject();
			fis.close();
			ois.close();
		}
		catch(Exception e)
		{}
	}
	public void Save()
	{
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try
		{
			fos=new FileOutputStream("Mypaint.dat");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(ls);
			fos.close();
			oos.close();
		}
		catch(Exception e2)
		{}

	}
	public static void main(String []args)
	{
		Mouse4 a=new Mouse4();
	}
}