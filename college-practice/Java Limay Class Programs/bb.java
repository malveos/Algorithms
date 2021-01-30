import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
/*
	<applet code=bb.class
			width=500
			height=400
	>
	</applet>
*/

 class ball extends Thread
{
	JPanel pan;
	int x,y,dx,dy;
	Color cr;
	ball(JPanel p)
	{
		super();
		pan=p;
		dx=dy=2;//(int)(Math.random()*9)+1;
		x=0;y=(int)(Math.random()*400);
		cr=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		start();
	}
	public void run()
	{
		while(true)
		{
		update();
		try
		{
			Thread.sleep(15);
		}
		catch(Exception e){}
		}
	}
	public void update()
	{
		Graphics g=pan.getGraphics();
		g.setColor(Color.white);
		g.fillArc(x,y,35,35,0,360);
		x+=dx;
		y+=dy;
		g.setColor(cr);
		g.fillArc(x,y,35,35,0,360);

		if(x<=0||x>=500)
			dx=-dx;

		if(y<=0||y>=400)
			dy=-dy;
	}
}

public class bb extends JApplet implements ActionListener
{
	JPanel p1,p2;
	JButton bn,be;
	public void init()
	{
		p1=new JPanel();
		p2=new JPanel();
		bn=new JButton("New");
		be=new JButton("Exit");
		bn.addActionListener(this);
		be.addActionListener(this);
		p2.setLayout(new FlowLayout());
		p2.add(bn);
		p2.add(be);
		add(p1,"Center");
		add(p2,"South");
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton b=(JButton)e.getSource();
		if(b==bn)
			{ball x=new ball(p1);}
		/*else
		{
			try
			{
			x.stop();}catch(Exception e1){}
		}*/
	}
}