import java.awt.*;
import java.awt.event.*;

class UseWindowAdapter extends Frame
{
	UseWindowAdapter()
	{
		super("WindowAdapter");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});
		setVisible(true);
		setSize(400,400);
	}
	public static void main(String []args)
	{
		UseWindowAdapter a=new UseWindowAdapter();
	}
}