import java.awt.*;
import java.awt.event.*;
class Mouseclicks extends Frame implements WindowListener,ActionListener,MouseListener,FocusListener
{
	Label l,r;
	TextField tl,tr;
	int lc,rc;
	Panel P1,P2;
	Color cr;
	Mouseclicks(String s)
	{
		super(s);
		l=new Label("Left");
		r=new Label("Right");
		tl=new TextField(10);
		tr=new TextField(10);
		tl.addFocusListener(this);
		tr.addFocusListener(this);
		P2=new Panel();
		P2.setBackground(new Color(255,0,0));
		P1=new Panel();
		P1.setLayout(new GridLayout(1,4,0,0));
		P1.add(l);
		
		P1.add(tl);
		P1.add(r);
		P1.add(tr);
		
		add(P2,BorderLayout.CENTER);
		add(P1,BorderLayout.SOUTH);
		addWindowListener(this);
		P2.addMouseListener(this);
		setVisible(true);
		setSize(400,400);
		
	}
	public void actionPerformed(ActionEvent e){}
	public void focusGained(FocusEvent e){}

	public void focusLost(FocusEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	public void mouseClicked(MouseEvent e)
	{
		int x=e.getButton();
		if(x==1)
		{
			lc++;
			tl.setText(""+lc);
		}
		if(x==3)
		{
			rc++;
			tr.setText(""+rc);
		}
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public static void main(String []args)
	{
		Mouseclicks m=new Mouseclicks("Mouse clicks count");
	}
}