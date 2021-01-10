import java.awt.*;
import java.awt.event.*;
import mypkg.MyColor;
import java.io.*;
import mypkg.Util;

class Editor extends Frame implements ActionListener,ItemListener
{
	Button bn,bo,bs,bfc,bbc,bf,bfr;
	Color fcr,bcr;
	TextArea ta;
	Font f;
	int size,style;
	String fontname;
	FileOutputStream fr;
	FileInputStream fw;
	String str;
	Panel p1,p2;
	CheckboxGroup cg1;
	Checkbox cb,ci,cp;
	Choice fnm,fsize;
	Editor()
	{
		super("Text Editor");
		bn=new Button("New");
		bo=new Button("Open");
		bs=new Button("Save");
		bfc=new Button("Font Color");
		bbc=new Button("BColor");
		bf=new Button("Find");
		bfr=new Button("Find & Replace");

		bn.addActionListener(this);
		bo.addActionListener(this);
		bs.addActionListener(this);
		bfc.addActionListener(this);
		bbc.addActionListener(this);
		bf.addActionListener(this);
		bfr.addActionListener(this);

		p1=new Panel();
		p1.add(bn);
		p1.add(bo);
		p1.add(bs);
		p1.add(bfc);
		p1.add(bbc);
		p1.add(bf);
		p1.add(bfr);

		add(p1,BorderLayout.SOUTH);

		ta=new TextArea("",40,80,TextArea.SCROLLBARS_BOTH);
		add(ta,BorderLayout.CENTER);
		cg1=new CheckboxGroup();
		cb=new Checkbox("Bold",cg1,false);
		ci=new Checkbox("Italic",cg1,false);
		cp=new Checkbox("Plain",cg1,false);
		cb.addItemListener(this);
		ci.addItemListener(this);
		cp.addItemListener(this);

		fnm=new Choice();
		fnm.add("Arial");
		fnm.add("Roman");
		fnm.add("Serif");
		fnm.addItemListener(this);

		fsize=new Choice();
		fsize.add("6");
		fsize.add("8");
		fsize.add("10");
		fsize.add("12");
		fsize.add("15");
		fsize.add("18");
		fsize.add("20");
		fsize.add("25");
		fsize.addItemListener(this);
		p2=new Panel();
		p2.add(fnm);
		p2.add(fsize);
		p2.add(cb);
		p2.add(ci);
		p2.add(cp);

		add(p2,BorderLayout.NORTH);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});
		style=Font.PLAIN;
		size=100;
		fontname="Roman";
		f=new Font(fontname,style,size);
		ta.setFont(f);
		fcr=new Color(0,0,0);
		bcr=new Color(255,255,255);
		ta.setForeground(fcr);
		ta.setBackground(bcr);

		setSize(700,500);
		setVisible(true);


	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==bn)
		{
			str=new String();
			ta.setText(str);
			fcr=new Color(0,0,0);
			bcr=new Color(255,255,255);
			ta.setBackground(bcr);
			ta.setForeground(fcr);
			return;
		}
		if(b==bo)
		{
			FileDialog fd=null;
			fd=new FileDialog(this,"File Open",FileDialog.LOAD);
			fd.setVisible(true);
			String s=fd.getDirectory()+fd.getFile();
			str=null;
			ObjectInputStream ois=null;
			try
			{
				fw=new FileInputStream(s);
				ois=new ObjectInputStream(fw);
				fcr=(Color)ois.readObject();
				bcr=(Color)ois.readObject();
				f=(Font)ois.readObject();
				str=(String)ois.readUTF();
				ois.close();
				ta.setForeground(fcr);
				ta.setBackground(bcr);
				
				ta.setFont(f);
				ta.setText(str);

			}
			catch(Exception e2)
			{}
			return;
		}
		if(b==bs)
		{
			FileDialog fd=null;
			fd=new FileDialog(this,"File Save",FileDialog.SAVE);
			fd.setVisible(true);
			String s=fd.getDirectory()+fd.getFile();
			str=null;
			ObjectOutputStream ois=null;
			try
			{
				fr=new FileOutputStream(s);
				ois=new ObjectOutputStream(fr);
				//ois.writeObject(fw);
				ois.writeObject(fcr);
				ois.writeObject(bcr);
				ois.writeObject(f);
				str=ta.getText();
				ois.writeUTF(str);
				ois.close();
				

			}
			catch(Exception e2)
			{}
			return;
		}
		if(b==bfc)
		{
			MyColor a=new MyColor(this,"Select Color",true);
			a.setVisible(true);
			fcr=new Color(a.r,a.g,a.b);
			ta.setForeground(fcr);
			return;
		}
		if(b==bbc)
		{
			MyColor a=new MyColor(this,"Select Color",true);
			a.setVisible(true);
			bcr=new Color(a.r,a.g,a.b);
			ta.setBackground(bcr);
			return;
		}
		if(b==bf)
		{
			String s=Util.sInput("Enter Search String");
			int i=-1,j=1,cnt=0;
			str=ta.getText();
			int l=str.length(),k=0;
			int p=ta.getText().indexOf(s);
			p=str.indexOf(s);
			int q=s.length();


			if(p==-1)
				Util.display("String not found");
			else
				ta.select(p,p+q);
		}
		if(b==bfr)
		{
			String s=Util.sInput("Enter search String");
			String r=Util.sInput("Enter replace String");
			str=ta.getText();
			int pos=str.indexOf(s);
			if(pos==-1)
				Util.display("String not found");
			else
				ta.setText(str.replaceAll(s,r));
		}


	}
	public void itemStateChanged(ItemEvent e)
	{
		Choice c=null;
		Checkbox b=null;
		try
		{
			c=(Choice)e.getSource();
		}
		catch(Exception e2)
		{
			b=(Checkbox)e.getSource();
		}
		if(c==fnm)
		{
			fontname=c.getSelectedItem();
			f=new Font(fontname,style,size);
			ta.setFont(f);
		}
		if(c==fsize)
		{
			try
			{
				size=Integer.parseInt(c.getSelectedItem());
			}
			catch(Exception e1){}
			f=new Font(fontname,style,size);
			ta.setFont(f);
		}
		if(b==cb)
		{			
			f=new Font(fontname,Font.BOLD,size);
			ta.setFont(f);
		}
		if(b==ci)
		{			
			f=new Font(fontname,Font.ITALIC,size);
			ta.setFont(f);
		}
		if(b==cp)
		{			
			f=new Font(fontname,Font.PLAIN,size);
			ta.setFont(f);
		}



	}
	public static void main(String args[])
	{
		Editor e=new Editor();
	}
}
