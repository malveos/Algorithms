import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import mypkg.Util;


class Mouse2 extends Frame
{
	int flg,x1,y1,x2,y2;
	int r,g,b;
	Color cr;
	Mouse2()
	{
		super("line with points");
		flg=0;
	
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(flg==0)
				{
					x1=e.getX();
					y1=e.getY();
					flg=1;
				}
				else
				{
					x2=e.getX();
					y2=e.getY();
					flg=0;
					draw();
				}
			}

		});
		setVisible(true);
		setSize(400,400);
	}
	void draw()
	{
		Graphics gl=getGraphics();
		r=(int)(Math.random()*255);
		g=(int)(Math.random()*255);
		b=(int)(Math.random()*255);
		cr=new Color(r,g,b);
		gl.setColor(cr);
		gl.drawLine(x1,y1,x2,y2);
	}
	public static void main(String []args)
	{
		Mouse2 a=new Mouse2();
	}
}