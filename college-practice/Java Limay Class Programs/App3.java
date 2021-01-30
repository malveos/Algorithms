import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
	<applet code="App3.class"
			width=400
			height=400>
	</applet>		
	
*/
public class App3 extends Applet
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
					flg=0;
					repaint();
					
				}
			}
		});
	}
	public void paint(Graphics g){
		
			g.drawRect(x,y,w,h);
	}
	
}
