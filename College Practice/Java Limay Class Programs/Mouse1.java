import java.awt.event.*;
import mypkg.Util;
import java.awt.*;

class Mouse1 extends Frame implements MouseListener,MouseMotionListener
{
	String str;
	int x,y;
	Mouse1()
	{
		super("mouse");
		x=y=100;
		str="MOUSE";
		addMouseListener(this);
		addMouseMotionListener(this);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});
		setVisible(true);
		setSize(200,200);
	}
	public void paint(Graphics g)
	{
		g.drawString(str,x,y);
	}
	public void mousePressed(MouseEvent e)
	{
		x=e.getX();
		y=e.getY();
		str="Mouse pressed";
		repaint();
	}
	public void mouseReleased(MouseEvent e)
	{
		x=e.getX();
		y=e.getY();
		str="Mouse Released";
		repaint();
	}
	public void mouseEntered(MouseEvent e)
	{
		x=50;
		y=50;
		str="Mouse Entered";
		repaint();
	}
	public void mouseExited(MouseEvent e)
	{
		x=50;
		y=50;
		str="Mouse Exited";
		repaint();
	}
	public void mouseClicked(MouseEvent e)
	{
		x=e.getX();
		y=e.getY();
		str="Mouse Clicked";
		repaint();
	}
	public void mouseMoved(MouseEvent e)
	{
		x=e.getX();
		y=e.getY();
		str="Mouse Moved";
		repaint();
	}
	public void mouseDragged(MouseEvent e)
	{
		x=e.getX();
		y=e.getY();
		str="Mouse Dragged";
		repaint();
	}
	public static void main(String []args)
	{
		Mouse1 s=new Mouse1();
	}
}