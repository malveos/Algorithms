import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
	<applet code="MyApplet.class width="200" height="200">
	</applet>
*/

class MyApplet extends Applet
{
	int x, y, w, h, fg;
	public void init()
	{
		fg=0;
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(fg==0)
				{
					x=e.getX();y=e.getY();fg=1;
				}
				else
				{
					w=e.getX()-x;h=e.getY()-y;fg=0;
					draw();
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