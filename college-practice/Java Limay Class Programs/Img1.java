import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
	<applet code="Img1.class"
			width=400
			height=400>
	</applet>		
	
*/
	public class Img1 extends Applet
	{
		Image img;
		public void init()
		{
			img=getImage(getDocumentBase(),"osm.jpg");

		}
		public void paint(Graphics g)
		{
			g.drawImage(img,20,20,360,360,this);
		}
	}
