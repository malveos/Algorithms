import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import mypkg.Shape;
class Mousex extends Frame
{
	int x1,x2,y1,y2,flg,r,g,b;
	Color cr;
	Shape sobj;
	Mousex()
	{
		super("draw rect");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(flg==0)
				{
					x1=e.getX();
					y1=e.getY();
					flg=1;
				}
				else
				{
					x2=e.getX()-x1;
					y2=e.getY()-y1;
					flg=0;
					draw();
				}
			}
		});
		setSize(500,500);
		setVisible(true);
	}
	void draw()
	{
		r=(int)(Math.random()*255);
		g=(int)(Math.random()*255);
		b=(int)(Math.random()*255);
		cr=new Color(r,g,b);
		sobj=new Shape(x1,y1,x2,y2,3,cr);
		sobj.draw(this);
		setBackground(new Color(255,255,255));
	}
	public static void main(String []args)
	{
		Mousex a=new Mousex();
	}
}