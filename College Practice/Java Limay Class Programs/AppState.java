import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
	<applet code="AppState.class"
			width=400
			height=400>
	</applet>		
	
*/
public class AppState extends Applet
{
	int init,paint,destroy,start,stop;
	public void init(){
		init=0;paint=0;
		destroy=0;
		start=0;
		stop=0;
		init++;}
	public void paint(Graphics g){paint++;}
	public void destroy(){destroy++;
		System.out.println("init:"+init+"\npaint:"+paint+"\nstart:"+start+"\nstop:"+stop+"\ndestroy:"+destroy);
	}
	public void start(){start++;}
	public void stop(){stop++;}
}