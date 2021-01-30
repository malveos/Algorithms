import java.awt.*;
import mypkg.Util;
import java.awt.event.*;
class Frm2 extends Frame implements ActionListener
{
	Button b1,b2;
	Frm2(String s)
	{
		super(s);
		b1=new Button("OK");
		b2=new Button("CANCEL");
		setLayout(null);
		b1.setBounds(50,120,100,20);
		b2.setBounds(170,120,100,20);
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);
		add(b2);
		
		setSize(320,260);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==b1)
			Util.display("PGm Runnn!!!!!!!");
		else
			System.exit(0);
	}
	public static void main(String []args)
	{
		Frm2 a=new Frm2("UseButton");
	}
}