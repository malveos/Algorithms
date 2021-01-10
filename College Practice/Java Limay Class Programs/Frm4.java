import java.awt.*;
import mypkg.Util;
import java.awt.event.*;
class Frm4 extends Frame implements ActionListener,WindowListener
{
	Button Bok,Bex;
	Label Lno,Lnm;
	TextField Tno,Tnm;
	Frm4(String s)
	{
		super(s);
		Bok=new Button("OK");
		Bex=new Button("CANCEL");
		Bok.addActionListener(this);
		Bex.addActionListener(this);
		Lno=new Label("Roll no:");
		Lnm=new Label("Name:");
		Tno=new TextField(10);
		Tnm=new TextField(40);
		setLayout(new GridLayout(3,2,5,5));
		add(Lno);
		add(Tno);
		add(Lnm);
		add(Tnm);
		add(Bok);
		add(Bex);
		addWindowListener(this);
		setSize(320,260);
		setVisible(true);
	}
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
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==Bex)
			System.exit(0);
		else
		{
			String s="\nRoll no:"+Tno.getText()+"\nName:"+Tnm.getText();
			Util.display(s);
			Tno.setText("");
			Tnm.setText("");
			//Tno.requestFous();
		}
	}
	public static void main(String []args)
	{
		Frm4 a=new Frm4("STUDENT");
	}
}