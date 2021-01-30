import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
<html>
	<body>
		<applet code="App1.class"
				width=400
				height=400>
		</applet>	
	</body>
</html>		
*/

public class App1 extends Applet
{
	String str;
	public void init()
	{
		str="Welcome";

	}
	public void paint(Graphics g)
	{
		g.drawString(str,100,100);
	}
}