import java.awt.*;
import java.awt.event.*;
class MiniCalculator extends Frame implements WindowListener,ActionListener,FocusListener
{
	Label L1,L2,L3;
	TextField T1,T2,T3;
	Button Ba,Bs,Bm,Bd,Bc;
	Panel P1,P2;
	double v1,v2,res;
	char oper;
	void comp()
	{
		switch(oper)
		{
			case '+':
					res=v1+v2;
					break;
			case '-':
					res=v1-v2;
					break;
			case '*':
					res=v1*v2;
					break;
			case '/':
					res=v1/v2;
					break;
		}
	}
	MiniCalculator(String s)
	{
		super(s);
		L1=new Label("Value1");
		L2=new Label("Value2");
		L3=new Label("Result");
		
		T1=new TextField(10);
		T2=new TextField(10);
		T3=new TextField(10);
		T1.addFocusListener(this);
		T2.addFocusListener(this);
		T3.addFocusListener(this);
		
		Ba=new Button("+");
		Bs=new Button("-");
		Bm=new Button("*");
		Bd=new Button("/");
		Bc=new Button("C");
		
		Ba.addActionListener(this);
		Bs.addActionListener(this);
		Bm.addActionListener(this);
		Bd.addActionListener(this);
		Bc.addActionListener(this);
		
		Ba.setBackground(Color.green);
		Bs.setBackground(Color.green);
		Bm.setBackground(Color.green);
		Bd.setBackground(Color.green);
		Bc.setBackground(Color.red);
		
		Ba.setEnabled(false);
		Bs.setEnabled(false);
		Bm.setEnabled(false);
		Bd.setEnabled(false);
		Bc.setEnabled(false);
		addWindowListener(this);
		
		P1=new Panel();
		P2=new Panel();
		
		P1.setLayout(new GridLayout(1,5,0,0));
		P1.add(Ba);
		P1.add(Bs);
		P1.add(Bm);
		P1.add(Bd);
		P1.add(Bc);
		add(P1,BorderLayout.SOUTH);
		
		P2.setLayout(new GridLayout(3,2,0,0));
		P2.add(L1);
		P2.add(T1);
		P2.add(L2);
		P2.add(T2);
		P2.add(L3);
		P2.add(T3);
		add(P2,BorderLayout.CENTER);
		setSize(300,300);
		setVisible(true);
	
	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		
		
			if(b==Ba)
			{
				oper='+';
				comp();
				T3.requestFocus();
			}
				
			if(b==Bs)
			{
				oper='-';
				comp();
				T3.requestFocus();
			}
				
			if(b==Bm)
			{
				oper='*';
				comp();
				T3.requestFocus();
			}
				
			if(b==Bd)
			{
				oper='/';
				comp();
				T3.requestFocus();
			}
			
			if(b==Ba||b==Bs||b==Bm||b==Bd)
			{
				T3.setText(""+res);
				Ba.setEnabled(false);
				Bs.setEnabled(false);
				Bm.setEnabled(false);
				Bd.setEnabled(false);
				Bc.setEnabled(false);
			}
			if(b==Bc)
			{
				T1.setText("");
				T2.setText("");
				T3.setText("");
				T3.requestFocus();
				v1=v2=res=0.0;
			}
	}
	public void focusGained(FocusEvent e)
	{
		TextField t=(TextField)e.getSource();
		if(t==T3)
		{
			Ba.setEnabled(true);
			Bs.setEnabled(true);
			Bm.setEnabled(true);
			Bd.setEnabled(true);
			Bc.setEnabled(true);
		}
	}
	public void focusLost(FocusEvent e)
	{
		TextField t=(TextField)e.getSource();
		if(t==T1)
		{
			try
			{
				v1=Double.parseDouble(T1.getText());
			}
			catch(Exception e1)
			{
				T1.requestFocus();
				T1.setText("");
				return;
			}
		}
		if(t==T2)
		{
			try
			{
				v2=Double.parseDouble(T2.getText());
			}
			catch(Exception e2)
			{
				T2.requestFocus();
				T2.setText("");
				return;
			}
		}	
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
	public static void main(String []args)
	{
		MiniCalculator m=new MiniCalculator("MiniCalculator");
	}
}