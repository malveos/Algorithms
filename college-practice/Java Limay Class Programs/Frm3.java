import java.awt.*;
import mypkg.Util;
import java.lang.Math;
import java.awt.event.*;
class Frm3 extends Frame implements ActionListener
{
	Button br,bg,bb,brnd,be;
	Color cr;
	Panel P1,P2;
	int r,g,bx;
	Frm3(String s)
	{
		super(s);
		P1=new Panel();
		P2=new Panel();
		br=new Button("RED");
		bg=new Button("GREEN");
		bb=new Button("BLUE");
		brnd=new Button("RANDOM");
		be=new Button("EXIT");
		br.setBackground(Color.red);
		bg.setBackground(Color.green);
		bb.setBackground(Color.blue);
		brnd.setBackground(Color.pink);
		br.addActionListener(this);
		bg.addActionListener(this);
		bb.addActionListener(this);
		brnd.addActionListener(this);
		be.addActionListener(this);
		//P1.setLayout(null);
		//br.setBounds(0,0,20,20);
		//setLayout(new GridLayout(5,2,5,5));
		P1.add(br);
		P1.add(bg);
		P1.add(bb);
		P1.add(brnd);
		P1.add(be);
	
	
		add(P2,BorderLayout.CENTER);
		add(P1,BorderLayout.NORTH);
		
		setSize(320,260);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==be)
			System.exit(0);
		if(b==br)
			cr=new Color(255,0,0);
		if(b==bg)
			cr=new Color(0,255,0);
		if(b==bb)
			cr=new Color(0,0,255);
		if(b==brnd)
		{
			
			r=(int)(Math.random()*255);
			g=(int)(Math.random()*255);
			bx=(int)(Math.random()*255);
			cr=new Color(r,g,bx);
		}
		P2.setBackground(cr);
			
	}
	public static void main(String []args)
	{
		Frm3 a=new Frm3("COLORS");
	}
}