import java.awt.*;
import java.awt.event.*;
import mypkg.Util;
class Student1 extends Frame implements WindowListener,FocusListener,ActionListener
{
	Label Lno,Lnm,Lmrk;
	TextField Tno,Tnm,Tmrk;
	Button Bok,Bclr;
	int rno;
	String nm;
	double mrk;
	Student1(String s)
	{
		super(s);
		Lno=new Label("Roll no");
		Lnm=new Label("Name");
		Lmrk=new Label("Marks");

		Tno=new TextField(10);
		Tnm=new TextField(40);
		Tmrk=new TextField(10);
		
		Tno.addFocusListener(this);
		Tnm.addFocusListener(this);
		Tmrk.addFocusListener(this);
		
		Bok=new Button("OK");Bok.setEnabled(false);
		Bclr=new Button("CLEAR");Bclr.setEnabled(false);
		
		Bok.addActionListener(this);
		Bclr.addActionListener(this);
		
		addWindowListener(this);
		setLayout(null);
		Lno.setBounds(50,50,100,20);
		Tno.setBounds(170,50,100,20);
		Lnm.setBounds(50,80,100,20);
		Tnm.setBounds(170,80,160,20);
		Lmrk.setBounds(50,110,100,20);
		Tmrk.setBounds(170,110,100,20);
		Bok.setBounds(50,130,100,20);
		Bclr.setBounds(230,130,100,20);
		add(Lno);
		add(Tno);
		add(Lnm);
		add(Tnm);
		add(Lmrk);
		add(Tmrk);
		add(Bok);
		add(Bclr);
		setSize(380,200);
		setVisible(true);
	}	
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==Bok)
		{
			String s="Roll No:"+rno+"\nName:"+nm+"\nMarks:"+mrk;
			Util.display(s);
			
		}
	
		
		Tmrk.setText("");
		Tnm.setText("");
		Tno.setText("");
		Tno.requestFocus();
		mrk=0.0;
		rno=0;
		nm="";
		
	}
	public void focusGained(FocusEvent e)
	{
		TextField t=(TextField)e.getSource();
		
	}
	
	public void focusLost(FocusEvent e)
	{
		TextField t=(TextField)e.getSource();
		if(t==Tno)
		{
			try
			{
				rno=Integer.parseInt(Tno.getText());
			}
			catch(Exception e1)
			{
				Tno.requestFocus();
				return;
			}
			if(rno<0)
			{
				Tno.requestFocus();
				return;
				
			}
		}
		if(t==Tmrk)
		{
			
			try
			{
				nm=Tnm.getText();
				mrk=Double.parseDouble(Tmrk.getText());
			}
			catch(Exception e2)
			{
				Tmrk.requestFocus();
				return;
			}
			if(mrk<0.0||mrk>10.0)
			{
				Tmrk.requestFocus();
				return;
				
			}
		
			Bok.setEnabled(true);
			Bclr.setEnabled(true);
		}
	}
	
	public void windowOpened(WindowEvent e)
	{
	}
	public void windowActivated(WindowEvent e)
	{
	}
	public void windowDeactivated(WindowEvent e)
	{
	
	}
	public void windowIconified(WindowEvent e)
	{
	
	}
	public void windowDeiconified(WindowEvent e)
	{
	}
	public void windowClosed(WindowEvent e)
	{
	}
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	public static void main(String []args)
	{
		Student1 st=new Student1("Wce Student");
	}
}