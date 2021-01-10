import mypkg.MyPanel;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
	<applet code="App4.class"
			width=400
			height=400>
	</applet>		
	
*/
public class App4 extends Applet
{
	MyPanel pan;
	Image img;
	public void init()
	{
		img=getImage(getDocumentBase(),"osm.jpg");
		pan=new MyPanel();
		pan.setImage(img);
		setLayout(new BorderLayout());
		add(pan,BorderLayout.CENTER);
	}
	public void paint(Graphics g){}
}