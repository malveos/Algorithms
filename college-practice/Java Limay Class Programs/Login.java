import java.awt.*;
import java.awt.event.*;
import mypkg.Util;
class  Login extends Frame implements FocusListener,ActionListener
{
	Label lid,lpd;
	TextField tid,tpd;
	Button bok,bclr;
	String id,pass;

	Login()
	{
		super("Login");
		lid=new Label("ID:");
		lpd=new Label("Password");

		tid=new TextField(10);
		tpd=new TextField(10);tpd.setEchoChar('*');

		tid.addFocusListener(this);
		tpd.addFocusListener(this);

		bok=new Button("OK");
		bclr=new Button("Clear");

		bok.addActionListener(this);
		bclr.addActionListener(this);


		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});

		setLayout(new GridLayout(3,2,5,5));
		add(lid);
		add(tid);
		add(lpd);
		add(tpd);
		add(bok);
		add(bclr);
		setVisible(true);
		setSize(200,200);
	}
	public boolean isValidPassword()
	{
		String sk=tpd.getText();
		if(sk.length()<8)
			return false;
		int i=0,n=sk.length(),ac=0,dc=0,oc=0;

		while(i<n)
		{
			char ch=sk.charAt(i);
			if((ch>=65&&ch<=90)||(ch>=97&&ch<=122))
				ac++;
			else
			{
				if(ch>=48&&ch<=57)
					dc++;
				else
					oc++;
			}
			i++;
		}


		return (ac!=0&&dc!=0&&oc!=0);
	}
	public void focusGained(FocusEvent e)
	{
		TextField t=(TextField)e.getSource();
		if(t==tid)
		{

			bok.setEnabled(false);
		}	
	}

	public void focusLost(FocusEvent e)
	{
		TextField t=(TextField)e.getSource();
		if(t==tid)
		{
			int id=0;
			try
			{
				id=Integer.parseInt(tid.getText());
			}
			catch(Exception e99)
			{
				tid.requestFocus();
				return;
			}
			if(id<0)
			{
				tid.requestFocus();
				return;
			}		

		}
		else
		{
			if(isValidPassword()==false)
			{
				tpd.setText("");
				tpd.requestFocus();
				return;

			}
			else
				bok.setEnabled(true);
		}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		Button t=(Button)e.getSource();
		if(t==bok)
		{
			int id=0;String str="";
			try{
				id=Integer.parseInt(tid.getText());
				str=tpd.getText();
			}
			catch(Exception e1){}


			if(id==12345&&str.equals("Aa1_23456"))
				Util.display("Login Successful");
			else
				Util.display("Login Failed!!!");
		}
		tid.setText("0");
		tpd.setText("");
		tid.requestFocus();
	}


	public static void main(String []args)
	{
		Login l=new Login();
	}
}