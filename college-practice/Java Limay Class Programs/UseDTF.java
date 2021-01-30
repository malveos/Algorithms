import mypkg.DTF;
import mypkg.Util;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
class UseDTF extends Frame implements ActionListener
{
	DTF dt;
	Date d;
	Button b1;
	Label l1;
	UseDTF()
	{
		super("UseDTF");
		setLayout(new FlowLayout());
		l1=new Label("Birth date:");
		b1=new Button("OK");
		b1.addActionListener(this);
		dt=new DTF(10);
		d=null;
		add(l1);
		add(dt);
		add(b1);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setSize(400,400);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			d=dt.getDate();
		}
		catch(Exception ee){}
		System.out.println(dt.toString());
	}
	public static void main(String[] args) {
		UseDTF x=new UseDTF();
	}
}