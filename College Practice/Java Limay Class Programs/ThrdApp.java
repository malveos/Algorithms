import java.awt.*;
import java.awt.event.*;

class Thrd3 extends Thread
{
	Panel pan;
	Thrd3(String nm,Panel obj)
	{
		super(nm);
		pan=new Panel();
		pan=obj;
		start();
	}
	public void run()
	{
		Graphics g=pan.getGraphics();
		int x,y;
		while(true)
		{
			x=(int)(Math.random()*400);
			y=(int)(Math.random()*400);
			g.setColor(new Color(255,0,0));
			g.fillRect(x,y,30,30);
			try
			{
					Thread.sleep(1000);	
			}
			catch(Exception e3){}

		}
	}
}
class Thrd4 extends Thread
{
	Panel pan;
	Thrd4(String nm,Panel obj)
	{
		super(nm);
		pan=obj;
		start();
	}
	public void run()
	{
		Graphics g=pan.getGraphics();
		int x,y;
		while(true)
		{
			x=(int)(Math.random()*400);
			y=(int)(Math.random()*400);
			g.setColor(new Color(0,255,0));
			g.fillOval(x,y,30,30);
			try
			{
					Thread.sleep(2000);	
			}
			catch(Exception e3){}
			
		}
	}
}
class Thrd5 extends Thread
{
	Panel pan;
	Thrd5(String nm,Panel obj)
	{
		super(nm);
		pan=obj;
		start();
	}
	public void run()
	{
		Graphics g=pan.getGraphics();
		int x,y;
		while(true)
		{
			x=(int)(Math.random()*400);
			y=(int)(Math.random()*400);
			g.setColor(new Color(0,0,255));
			g.drawString("OMKAR",x,y);
			try
			{
					Thread.sleep(3000);	
			}
			catch(Exception e3){}
			
		}
	}
}
class Thrd6 extends Thread
{
	Panel pan;
	Thrd6(String nm,Panel obj)
	{
		super(nm);
		pan=obj;
		start();
	}
	public void run()
	{
		
		while(true)
		{
			
			try
			{
					Thread.sleep(10000);	
			}
			catch(Exception e3){}
			pan.repaint();

		}
	}
}

class ThrdApp extends Frame
{
	Thrd3 a;
	Thrd4 b;
	Thrd5 c;
	Thrd6 d;
	Panel pan;
	ThrdApp()
	{
		super("Multithread");
		pan=new Panel();
		add(pan,BorderLayout.CENTER);

		
		setSize(600,600);
		setVisible(true);
		a=new Thrd3("A",pan);
		b=new Thrd4("B",pan);
		c=new Thrd5("C",pan);
		d=new Thrd6("D",pan);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				a.stop();
				b.stop();
				c.stop();
				d.stop();
				System.exit(0);

			}
		});

	}
	public void paint(Graphics g){}
	public static void main(String[]args)
	{
		ThrdApp s=new ThrdApp();
	}

}