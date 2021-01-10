import mypkg.MyPanel;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
	<applet code="SlideShow.class"
			width=400
			height=400>
	</applet>		
	
*/
	public class SlideShow extends Applet implements ActionListener,ItemListener,Runnable
	{
		MyPanel pan;
		Image []img;
		int i,flg;
		Panel p;
		Button bf,bp,bn,bl;
		Checkbox ss;
		public void init()
		{
			bf=new Button("|<");
			bp=new Button("<<");
			bn=new Button(">>");
			bl=new Button(">|");
			ss=new Checkbox("SlideShow");

			ss.addItemListener(this);
			bf.addActionListener(this);
			bp.addActionListener(this);
			bn.addActionListener(this);
			bl.addActionListener(this);

			p=new Panel();
			p.add(ss);
			p.add(bf);
			p.add(bp);
			p.add(bn);
			p.add(bl);

			pan=new MyPanel();
			setLayout(new BorderLayout());
			add(pan,BorderLayout.CENTER);
			add(p,BorderLayout.SOUTH);
			flg=0;

			img=new Image[10];
			for(i=0;i<10;i++)
			{
				img[i]=getImage(getDocumentBase(),i+".jpg");

			}
			i=0;
			pan.setImage(img[0]);
		}
		public void itemStateChanged(ItemEvent e)
		{
			if(ss.getState()==true)
			{
				Thread th=new Thread(this);
				flg=1;
				th.start();
			}
			else 
				flg=0;
		}
		public void run()
		{
			while(flg==1)
			{
				try
				{
					Thread.sleep(2000);
				}
				catch(Exception e){}
				if(++i>9)
					i=0;
				pan.setImage(img[i]);
			}
		}
		public void actionPerformed(ActionEvent e)
		{
			Button b=(Button)e.getSource();
			if(b==bf)
				i=0;
			if(b==bl)
				i=9;
			if(b==bp)
			{
				if(--i<0)
					i=9;
			}
			if(b==bn)
			{
				if(++i>9)
					i=0;
			}
			pan.setImage(img[i]);
		}
		public void paint(Graphics g){}
	}