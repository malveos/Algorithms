import java.awt.*;
import mypkg.Util;
import java.awt.event.*;
class WCEStudent extends Frame implements ActionListener
{
	Label lno,lnm,ltrd,lgrp,lcty;
	TextField tnm,tno;
	Checkbox  ccse,cit,ccivil;
	CheckboxGroup cg1;
	Checkbox c1,c2,c3,c4,c5,c6;
	List city;
	Button bok,bclr;
	WCEStudent()
	{
		super("STUDENT");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});
		lno=new Label("Roll no");
		lnm=new Label("Name");
		ltrd=new Label("Trend");
		lgrp=new Label("Group");
		lcty=new Label("City");

		tno=new TextField(6);
		tnm=new TextField(20);

		cg1=new  CheckboxGroup();

		ccse=new Checkbox("cse",cg1,false);
		cit=new Checkbox("it",cg1,false);
		ccivil=new Checkbox("civil",cg1,false);

		c1=new Checkbox("PACE");
		c2=new Checkbox("Wlug");
		c3=new Checkbox("ArtCircle");
		c4=new Checkbox("Acsus");
		c5=new Checkbox("Rotract");
		
		city=new List(5);
		city.add("Lal Bazar");
		city.add("Vikarabad");
		city.add("Trichipalli");
		city.add("Nagampalli");
		city.add("Kachigudi");

		bok=new Button("OK");
		bclr=new Button("CLEAR");
		bok.addActionListener(this);
		bclr.addActionListener(this);

		setLayout(null);
		lno.setBounds(50,50,100,20);
		tno.setBounds(170,50,100,20);
		lnm.setBounds(50,80,100,20);
		tnm.setBounds(170,80,150,20);
		ltrd.setBounds(50,110,100,20);
		ccse.setBounds(50,140,100,20);
		cit.setBounds(170,140,100,20);
		ccivil.setBounds(290,140,100,20);
		lgrp.setBounds(50,170,100,20);
		c1.setBounds(50,210,60,20);
		c2.setBounds(120,210,60,20);
		c3.setBounds(190,210,60,20);
		c4.setBounds(260,210,60,20);
		c5.setBounds(330,210,60,20);
		lcty.setBounds(50,240,100,20);
		city.setBounds(50,280,100,100);
		bok.setBounds(50,400,100,20);
		bclr.setBounds(200,400,100,20);

		add(lno);
		add(tno);
		add(lnm);
		add(tnm);
		add(ltrd);
		add(ccse);
		add(cit);
		add(ccivil);
		add(lgrp);
		add(c1);
		add(c2);
		add(c3);
		add(c4);
		add(c5);
		add(lcty);
		add(city);	
		add(bok);
		add(bclr);


		setSize(800,800);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		Button b1=(Button)e.getSource();
		if(b1==bok)
		{
			String s="Roll No:"+tno.getText()+"\nName:"+tnm.getText()+"\nTrade:";
			String ss=(cg1.getSelectedCheckbox()).getLabel();
			s=s+ss+"\nGroup:\n\t";
			if(c1.getState())
				s=s+c1.getLabel()+"\n\t";
			if(c2.getState())
				s=s+c2.getLabel()+"\n\t";
			if(c3.getState())
				s=s+c3.getLabel()+"\n\t";
			if(c4.getState())
				s=s+c4.getLabel()+"\n\t";
			if(c5.getState())
				s=s+c5.getLabel()+"\n";

			s=s+"\nCity:"+city.getSelectedItem();
			Util.display(s);

		}
		if(b1==bclr)
		{	
			tno.setText("");
			tnm.setText("");
			c1.setState(false);
			c2.setState(false);
			c3.setState(false);
			c4.setState(false);

			tno.requestFocus();
		}
	}
	public static void  main(String[] args) 
	{
		WCEStudent x=new WCEStudent();
	
	}
}