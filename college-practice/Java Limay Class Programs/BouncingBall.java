import java.awt.*;
import java.awt.event.*;
public class BouncingBall
{

	public static void main(String []args)
	{
		BBFrame a=new BBFrame("Bouncing Balls");
	}
}

class BBFrame extends Frame implements ActionListener
{
	Button bn,be;
	Panel p,q;
	BBFrame(String s)
	{
		super(s);
		bn=new Button("new ");
		be=new Button("Exit");
		bn.addActionListener(this);
		be.addActionListener(this);

		q=new Panel();
		q.add(bn);
		q.add(be);
		add(q,BorderLayout.SOUTH);
		pack();
		p=new Panel();
		add(p,BorderLayout.CENTER);
		setSize(400,300);
		setResizable(false);
		setVisible(true);	
	}	
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==bn)
			{BObject x=new BObject(p);}
		else
			System.exit(0);
	}
}

class BObject extends Thread
{
	Panel box;
	static final int XSIZE=10;
	static final int YSIZE=10;
	int x,y,dx,dy;
	Color cr;
	BObject(Panel p)
	{
		super();
		box=p;
		x=0;
		dx=dy=(int)(Math.random()*10);;
		y=(int)(Math.random()*300);
		cr=new Color(((int)Math.random()*255),((int)(Math.random()*255)),((int)(Math.random()*255)));
		start();

	}
	public void run()
	{
		while(true)
		{
			move();
			try
			{
				Thread.sleep(10);

			}
			catch(Exception e1){}
		}
	}
	void move()
	{
		Graphics g=box.getGraphics();
		g.setColor(Color.white);
		g.fillArc(x,y,XSIZE,YSIZE,0,360);
		x+=dx;
		y+=dy;
		g.setColor(cr);
		g.fillArc(x,y,XSIZE,YSIZE,0,360);
		Dimension d=box.getSize();
		if(x <=0 || x>=d.width)
		{
			//x=d.width-XSIZE;
			dx=-dx;
		}
		if(y <=0 || y>=d.height)
		{
			//y=d.height-YSIZE;
			dy=-dy;
		}
	}
}