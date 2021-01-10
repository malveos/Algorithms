import mypkg.NTF;
import mypkg.DoubleTF;
import mypkg.Util;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
class UseNTF extends Frame implements ActionListener
{
	NTF n;
	//DoubleTF n;
	int no;
	Button b1;
	Label l1;
	UseNTF()
	{
		super("UseNTF");
		setLayout(new FlowLayout());
		l1=new Label("Number:");
		b1=new Button("OK");
		b1.addActionListener(this);
		n=new NTF(10);
		
		add(l1);
		add(n);
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
			no=n.getNumber();
		}
		catch(Exception ee){}
		System.out.println(n.toString());
	}
	public static void main(String[] args) {
		UseNTF x=new UseNTF();
	}
}