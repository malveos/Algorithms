import java.awt.*;
import java.awt.event.*;
class KeyDemo extends Frame
{
	int x,y;
	KeyDemo()
	{
		super("KeyDemo");
		x=20;y=20;
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});
		addKeyListener(new KeyAdapter()
				{
					public void keyPressed(KeyEvent e)
					{
						if(e.getKeyCode()==KeyEvent.VK_UP)
						{
							y-=2;
							if(y>480)
								y=480;
							repaint();
						}
						if(e.getKeyCode()==KeyEvent.VK_DOWN)
						{
							y+=2;
							if(y<0)
								y=0;
							repaint();
							
						}
						if(e.getKeyCode()==KeyEvent.VK_LEFT)
						{
							x-=2;
							if(x>480)
								x=480;
							repaint();
							
						}
						if(e.getKeyCode()==KeyEvent.VK_RIGHT)
						{
							x+=2;
							if(x<0)
								x=0;
							repaint();
							
						}
						if(e.getKeyCode()==KeyEvent.VK_HOME)
						{
							x=0;y=0;
							repaint();
						}
						if(e.getKeyCode()==KeyEvent.VK_END)
						{
							x=480;y=480;
							repaint();
						}
					}
				}
			);
		setSize(500,500);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		g.drawOval(x,y,20,20);
	}
	public static void main(String args[])
	{
		KeyDemo e=new KeyDemo();
	}
}
