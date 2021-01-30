import java.awt.*;
import java.awt.event.*;
class Mycolor extends Frame implements FocusListener
{
	int r,g,b;
	Label lr,lg,lb,lclr;
	TextField tr,tg,tb;
	Panel pr,pg,pb,pclr;
	Mycolor()
	{
		super("color");
		r=g=b=0;
		lr=new Label("red");
		lb=new Label("blue");
		lg=new Label("green");
		lclr=new Label("clear");

		tr=new TextField(6);
		tg=new TextField(6);
		tb=new TextField(6);
		tr.addFocusListener(this);
		tg.addFocusListener(this);
		tb.addFocusListener(this);

		pr=new Panel();
		pg=new Panel();
		pb=new Panel();
		pclr=new Panel();

		setLayout(null);
		lr.setBounds(50,50,70,20);
		lg.setBounds(140,50,70,20);
		lb.setBounds(230,50,70,20);
		lclr.setBounds(320,50,120,20);
		tr.setBounds(50,90,70,20);
		tg.setBounds(140,90,70,20);
		tb.setBounds(230,90,70,20);

		pr.setBounds(50,130,70,70);
		pg.setBounds(140,130,70,70);
		pb.setBounds(230,130,70,70);
		pclr.setBounds(320,90,120,110);

		add(lr);
		add(lg);
		add(lb);
		add(lclr);
		add(tr);
		add(tg);
		add(tb);
		add(pr);
		add(pb);
		add(pg);
		add(pclr);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});

		setSize(420,290);
		setVisible(true);
	} 
	public void focusGained(FocusEvent e){}

	public void focusLost(FocusEvent e)
	{
		TextField t=(TextField)e.getSource();
		int val=0;
		try
		{
			val=Integer.parseInt(t.getText());
		}
		catch(Exception e1)
		{

		}

		if(val<0||val>255)
		{
			t.requestFocus();
			return;
		}
		if(t==tr)r=val;
		if(t==tb)b=val;
		if(t==tg)g=val;

		pr.setBackground(new Color(r,0,0));
		pg.setBackground(new Color(0,g,0));
		pb.setBackground(new Color(0,0,b));
		pclr.setBackground(new Color(r,g,b));

	}


	public static void main(String []args)
	{
		Mycolor c=new Mycolor();
	}
}