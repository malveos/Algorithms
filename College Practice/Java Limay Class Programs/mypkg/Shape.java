package mypkg;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
public class Shape implements Serializable
{
	int x,y,w,h;
	Color cr;
	int shp;
	public Shape(int x,int y,int w,int h,int shp,Color cr)
	{
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.shp=shp;
		this.cr=cr;

	}
	public void draw(Frame obj)
	{
		Graphics g=obj.getGraphics();
		g.setColor(cr);
		switch(shp)
		{
			case 1:g.drawLine(x,y,w,h);
					break;
			case 2:g.drawRect(x,y,w,h);
					break;
			case 3:g.drawOval(x,y,w,h);
					break;
			case 4:
					g.fillRect(x,y,w,h);
					break;
			case 5:
					g.drawOval(x,y,w,h);
					g.fillOval(x,y,w,h);
					break;
			case 6:g.drawString("Omkar",x,y);
					break;		
		}
	}
}
