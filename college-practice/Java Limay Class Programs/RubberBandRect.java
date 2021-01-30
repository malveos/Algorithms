import java.awt.event.*;
import java.awt.*;
class RubberBandRect extends Frame
{
	int x,y,w,h;
	RubberBandRect()
	{
		super("Rect with Rubber Band");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});

		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				x=e.getX();
				y=e.getY();
				w=0;h=0;
			}
			public void mouseReleased(MouseEvent e)
			{
				w=e.getX()-x;
				h=e.getY()-y;
				draw(1);
			}
		});	
		addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
					draw(0);
					w=e.getX()-x;
					h=e.getY()-y;
					draw(1);
				
			}
		});
		setSize(800,800);
		setVisible(true);
	}
	void draw(int flg)
	{
		Graphics g=getGraphics();
		if(flg==0)
		{
			g.setXORMode(Color.white);
			g.drawRect(x,y,w,h);
		}
		else
			g.drawRect(x,y,w,h);
	}
	public static void main(String []args)
	{
		RubberBandRect a=new RubberBandRect();
	}
}