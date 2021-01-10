import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
class Menu2 extends Frame implements ActionListener
{
	MenuBar mb;
	Menu ms,mc,me;
	MenuItem msl,msr,mso,mss,mcr,mcg,mcb,mcrd,en,ey;
	int x1,y1,x2,y2,flg,shp,r,g,b;
	Color cr;
	Menu2()
	{
		super("PAINT");
		mb=new MenuBar();

		ms=new Menu("Shape");
		mc=new Menu("Color");
		me=new Menu("Exit");

		msl=new MenuItem("Line");
		msr=new MenuItem("Rectangle");
		mso=new MenuItem("Oval");
		mss=new MenuItem("String");
		mcr=new MenuItem("Red");
		mcg=new MenuItem("Green");
		mcb=new MenuItem("Blue");
		mcrd=new MenuItem("Random");
		en=new MenuItem("No");
		ey=new MenuItem("Yes");

		msl.addActionListener(this);
		msr.addActionListener(this);
		mso.addActionListener(this);
		mss.addActionListener(this);
		mcr.addActionListener(this);
		mcg.addActionListener(this);
		mcb.addActionListener(this);
		mcrd.addActionListener(this);
		en.addActionListener(this);
		ey.addActionListener(this);
		
		ms.add(msl);
		ms.add(msr);
		ms.add(mso);
		ms.add(mss);
		
		mc.add(mcr);
		mc.add(mcg);
		mc.add(mcb);
		mc.add(mcrd);

		me.add(en);
		me.add(ey);

		mb.add(ms);
		mb.add(mc);
		mb.add(me);
		flg=0;

		setMenuBar(mb);
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(flg==0)
				{
					x1=e.getX();
					y1=e.getY();
					if(shp==4)
						draw();	
					else
						flg=1;			//String
				}
				else
				{
					if(shp==1)				//line
					{
						x2=e.getX();
						y2=e.getY();
					}
					else
					{
						x2=e.getX()-x1;
						y2=e.getY()-y1;
					}
					draw();
					flg=0;
				}
			}
		});


		setSize(400,400);
		setVisible(true);

	}
	void draw()
	{
		Graphics gr=getGraphics();
		gr.setColor(cr);
		switch(shp)
		{
			case 1:
					gr.drawLine(x1,y1,x2,y2);
					break;
			case 2:
					gr.drawRect(x1,y1,x2,y2);
					break;
			case 3:
					gr.drawOval(x1,y1,x2,y2);
					break;
			case 4:
					gr.drawString("Om",x1,y1);
					break;						
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		MenuItem a=(MenuItem)e.getSource();
		if(a==msl)
			shp=1;
		if(a==msr)
			shp=2;
		if(a==mso)
			shp=3;
		if(a==mss)
			shp=4;
		if(a==mcr)
			cr=new Color(255,0,0);
		if(a==mcg)
			cr=new Color(0,255,0);
		if(a==mcb)
			cr=new Color(0,0,255);
		if(a==mcrd)
		{
			r=(int)(Math.random()*255);
			g=(int)(Math.random()*255);
			b=(int)(Math.random()*255);
			cr=new Color(r,g,b);
		}
		if(a==ey)
			System.exit(0);
			
	}
	public static void main(String []args)
	{
		Menu2 ab=new Menu2();
	}
}