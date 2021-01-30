import java.awt.*;
import java.awt.event.*;
class Calculator extends Frame implements ActionListener 
{
	TextField t;
	
	Button []b;
	Panel p;
	int o1,o2,fg,rs;
	char ch,o;
	String s1;
	Calculator()
	{
		super("calci");
		
		o1=o2=rs=fg=0;
		s1="";
		String []cap={"1","2","3","+","4","5","6","-","7","8","9","*","0","c","=","/"};
		b=new Button[16];
		p=new Panel();
		p.setLayout(new GridLayout(4,4,5,5));
		for(int i=0;i<16;i++)
		{
			b[i]=new Button(cap[i]);
			b[i].addActionListener(this);
			p.add(b[i]);
		}
		t=new TextField(20);
		t.setEditable(false);

		t.setBounds(50,50,100,50);
		p.setBounds(50,100,100,80);
		add(t,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
		//add(p);
		//add(t);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});
		setSize(200,220);
		setVisible(true);
	}
	void com()
	{
		switch(o)
		{
			case '+':rs=o1+o2;break;
			case '-':rs=o1-o2;break;
			case '*':rs=o1*o2;break;
			case '/':
						try{rs=o1/o2;}catch(Exception ee){}break;
			

		}
	}
	public void actionPerformed(ActionEvent e)
	{
		Button bb=(Button)e.getSource();
		ch=(e.getActionCommand()).charAt(0);
		if(ch=='c')
		{
			s1="";
			fg=0;
			t.setText("");
			o1=o2=rs=0;
			return;
		}
		if(ch=='=')
		{
			
			if(fg==1)
			{
				try
				{
					o2=Integer.parseInt(t.getText());
				}
				catch(Exception e2){}
				com();
				t.setText(""+rs);
				s1="";
				fg=0;return;

			}
			t.setText(""+rs);
			return;
		}
		if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
		{
			if(fg==0)
			{
				try
				{
					o1=Integer.parseInt(t.getText());
				}
				catch(Exception e2){}
				t.setText("");
				s1="";
				fg=1;
				o=ch;
			}
			else
			{try
				{
					o2=Integer.parseInt(t.getText());
				}
				catch(Exception e2){}
				com();
				o1=rs;
				s1="";
				o=ch;	
			}
			return;
		}
		s1=s1+ch;
		t.setText(s1);
	}
	public static void main(String []args)
	{
		Calculator xc=new Calculator();
	}

}