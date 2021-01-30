import java.awt.*;
import java.awt.event.*;
class Frm5 extends Frame implements WindowListener
{
	Frm5(String s)
	{
		super(s);
		addWindowListener(this);
		setSize(400,400);
		setVisible(true);
	}
	public void windowOpened(WindowEvent e)
	{
		System.out.println("Opened");
	}
	public void windowActivated(WindowEvent e)
	{
		System.out.println("Activated");
	}
	public void windowDeactivated(WindowEvent e)
	{
		System.out.println("Deactivated");
	}
	public void windowIconified(WindowEvent e)
	{
		System.out.println("Iconified");
	}
	public void windowDeiconified(WindowEvent e)
	{
		System.out.println("Deiconified");
	}
	public void windowClosed(WindowEvent e)
	{
		System.out.println("Closed");
	}
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	public static void main(String []args)
	{
		Frm5 a=new Frm5("WindowListener");
	}
}