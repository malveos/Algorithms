import java.awt.*;
import java.awt.event.*;
import mypkg.Util;
class Pan1 extends Panel implements ActionListener
{
	Label lno,lnm;
	TextField tno,tnm;
	Color cr;
	Button bok,bclr;
	Pan1()
	{
		super();
		lno=new Label("Roll no");
		lnm=new Label("Name");
		tno=new TextField(6);
		tnm=new TextField(40);
		bok=new Button("OK");
		bclr=new Button("CLEAR");
		bok.addActionListener(this);
		bclr.addActionListener(this);
		setLayout(new GridLayout(3,2,5,5));
		add(lno);
		add(tno);
		add(lnm);
		add(tnm);
		add(bok);
		add(bclr);

		setSize(1000,1000);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==bok)
		{
			String s="Roll no:"+tno.getText()+"Name:"+tnm.getText();
			Util.display(s);

		}
		tnm.setText("");
		tno.setText("");
		tno.requestFocus();
	}

}
class Pan2 extends Panel implements Runnable
{
	int x,y,flg;
	Pan2 tmp;
	Pan2()
	{
		super();
		flg=0;
		tmp=this;
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(flg==0)
				{
					Thread t=new Thread(tmp);
					flg=1;
					t.start();
				}
				else
					flg=0;
			}
		});
		setSize(1300,1300);
		setVisible(true);

	}
	public void run()
	{
		while(flg==1)
		{
			x=(int)(Math.random()*200);
			y=(int)(Math.random()*200);
			Graphics g=getGraphics();
			
			int r=(int)(Math.random()*255);
			int gr=(int)(Math.random()*255);
			int b=(int)(Math.random()*255);
			int s1=(int)(Math.random()*255);
			int s2=(int)(Math.random()*255);
			Color cr=new Color(r,gr,b);
			g.setColor(cr);
			g.drawOval(x,y,s1,s2);
			try
			{
				//g.setColor(cr);
				Thread.sleep(200);
			}
			catch(Exception e1){}
		}
	}
}
class Pan3 extends Panel implements ActionListener
{
	List cobj;
	Button ba,br,bd,bc;
	Pan3()
	{
		super();
		cobj=new List(10,true);
		ba=new Button("Add");
		br=new Button("Remove");
		bd=new Button("Display");
		bc=new Button("Clear");

		ba.addActionListener(this);
		br.addActionListener(this);
		bd.addActionListener(this);
		bc.addActionListener(this);

		add(cobj);
		add(ba);
		add(br);
		add(bd);
		add(bc);

		setSize(1300,1300);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==ba)
		{
			String s=Util.sInput("City name");
			cobj.add(s);
		}
		if(b==br)
		{
			int []p=cobj.getSelectedIndexes();
			if(p.length==0)
				return;
			int i=0;
			while(i<p.length)
			{
				cobj.remove(p[i]);
				i++;

			}

		}
		if(b==bd)
		{
			String []p=cobj.getSelectedItems();
			for(String s:p)
				Util.display(s);

		}
		if(b==bc)
			cobj.clear();
	}
} 
class UseCardLayout extends Frame implements ActionListener
{
	Panel main,pan;
	Pan1 a;Pan2 b;
	Pan3 c;
	CardLayout cl;
	Button bs,bt,bct;
	UseCardLayout()
	{
		super("Demo");
		bs=new Button("student");
		bt=new Button("thread");
		bct=new Button("city");
		bs.addActionListener(this);
		bt.addActionListener(this);
		bct.addActionListener(this);

		pan=new Panel();
		pan.add(bs);
		pan.add(bt);
		pan.add(bct);

		add(pan,BorderLayout.SOUTH);

		a=new Pan1();
		b=new Pan2();
		c=new Pan3();

		main=new Panel();
		cl=new CardLayout(20,20);
		main.setLayout(cl);
		main.add(a,"student");
		main.add(b,"thread");
		main.add(c,"city");

		add(main,BorderLayout.CENTER);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});
		setSize(1300,1300);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==bs)
			cl.show(main,"student");
		if(b==bt)
			cl.show(main,"thread");
		if(b==bct)
			cl.show(main,"city");
			
	}
	public static void main(String args[])
	{
		UseCardLayout e=new UseCardLayout();
	}
}