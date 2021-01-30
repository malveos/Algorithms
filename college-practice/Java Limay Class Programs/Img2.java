import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
	<applet code="Img2.class"
			width=400
			height=400>
	</applet>		
	
*/
	public class Img2 extends Applet
	{
		Image img;
		int x,y,w,h;
		public void init()
		{
			x=10;y=10;
			w=50;h=50;
			img=getImage(getDocumentBase(),"osm.jpg");
			addMouseListener(new MouseAdapter()
		   {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getButton()==MouseEvent.BUTTON1)
				{
					x+=10;
					y+=10;
					if(x>360||y>360)
					{
						x=360;y=360;
					}
				}
				if(e.getButton()==3)
				{
					x-=10;y-=10;
					if(x<50||y<50)
					{
						x=50;y=50;
					}
				}
				repaint();
			}
		  });
		}
		public void paint(Graphics g)
		{
			g.drawImage(img,x,y,w,h,this);
		}
	}