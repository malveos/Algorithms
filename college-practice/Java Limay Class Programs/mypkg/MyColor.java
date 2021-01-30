package mypkg;
import java.awt.event.*;
import java.awt.*;
public class MyColor extends Dialog implements ActionListener,AdjustmentListener,FocusListener 
{
	public int r,g,b;
	TextField tr,tg,tb;
	Button bok,bc;
	Label lr,lg,lb,lclr;
	Scrollbar sr,sg,sb;
	Panel pclr;
	public MyColor(Frame parent,String title,boolean bmode)
	{
		super(parent,title,bmode);

		lr=new Label("Red");
		lb=new Label("Blue");
		lg=new Label("Green");
		lclr=new Label("Color");

		tr=new TextField(30);
		tg=new TextField(30);
		tb=new TextField(30);

		tr.addFocusListener(this);
		tg.addFocusListener(this);
		tb.addFocusListener(this);

		sr=new Scrollbar(Scrollbar.VERTICAL,0,5,0,255);
		sb=new Scrollbar(Scrollbar.VERTICAL,0,5,0,255);
		sg=new Scrollbar(Scrollbar.VERTICAL,0,5,0,255);

		sr.addAdjustmentListener(this);
		sg.addAdjustmentListener(this);
		sb.addAdjustmentListener(this);

		pclr=new Panel();

		bok=new Button("Ok");
		bc=new Button("Cancel");

		bok.addActionListener(this);
		bc.addActionListener(this);

		setLayout(null);
		lr.setBounds(50,50,50,20);
		sr.setBounds(50,80,50,150);
		tr.setBounds(50,240,50,20);

		lg.setBounds(120,50,50,20);
		sg.setBounds(120,80,50,150);
		tg.setBounds(120,240,50,20);

		lb.setBounds(190,50,50,20);
		sb.setBounds(190,80,50,150);
		tb.setBounds(190,240,50,20);

		lclr.setBounds(280,50,150,20);
		pclr.setBounds(280,80,150,150);
		bok.setBounds(280,240,70,20);
		bc.setBounds(360,240,70,20);

		add(lr);
		add(sr);
		add(tr);
		add(lg);
		add(sg);
		add(tg);
		add(lb);
		add(sb);
		add(tb);
		add(lclr);
		add(pclr);
		add(bok);
		add(bc);
		setSize(480,310);

	}
	public void actionPerformed(ActionEvent e)
	{
		Button b1=(Button)e.getSource();
		if(b1==bok)
		{
			r=sr.getValue();
			b=sb.getValue();
			g=sg.getValue();
		}
		else
			{
				r=0;g=0;b=0;
			}
		setVisible(false);
	}
	public void focusGained(FocusEvent e){}
	public void focusLost(FocusEvent e)
	{
		int val=0;
		TextField t=(TextField)e.getSource();
		try
		{
			val=Integer.parseInt(t.getText());
		}
		catch(Exception e1){}

		if(val<0||val>255)
		{
			t.requestFocus();
			return;
		}
		if(t==tr)
		{
			r=val;
			sr.setValue(r);
		}
		if(t==tg)
		{
			g=val;
			sg.setValue(g);
		}
		if(t==tb)
		{
			b=val;
			sb.setValue(b);
		}
		Color cr=new Color(r,g,b);
		pclr.setBackground(cr);
	}
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		r=sr.getValue();
		b=sb.getValue();
		g=sg.getValue();

		tr.setText(""+r);
		tg.setText(""+g);
		tb.setText(""+b);

		Color cr=new Color(r,g,b);
		pclr.setBackground(cr);

	}
}
