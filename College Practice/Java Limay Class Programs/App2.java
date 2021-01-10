import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
	<applet code="App2.class"
			width=400
			height=400>
	</applet>		
	
*/
public class App2 extends Applet
{
	int x,y,w,h,flg;
	public void init()
	{
		flg=0;
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
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
					
					draw();
					flg=0;
				}
			}
		});
	}
	public void paint(Graphics g){}
	public void draw()
	{
		Graphics g=getGraphics();
		g.drawRect(x,y,w,h);
	}
}
