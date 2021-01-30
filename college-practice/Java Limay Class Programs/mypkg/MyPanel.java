package mypkg;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends Panel
{
	Image img;
	public MyPanel()
	{
		super();
	}
	public void setImage(Image img)
	{
		this.img=img;
		repaint();

	}
	public void paint(Graphics g)
	{
		g.drawImage(img,20,20,200,200,this);
	}
}