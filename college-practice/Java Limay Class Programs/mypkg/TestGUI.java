package mypkg;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mypkg.DMD;
import javax.swing.table.*;
import java.util.*;
import mypkg.Util;

public class TestGUI extends Dialog implements ActionListener,FocusListener
{
	Label lid,lnm,lfee;
	TextField tid,tnm,tfee;
	Button bu,bd,bb;
	ResultSet rs;
	String action;
	int id,fee;
	String nm;
	Panel p1,p2;
	boolean res;
	PreparedStatement ps;
	LinkedList<String []>ls;
	DataTable db;
	public TestGUI(Frame parent,String title,Boolean Model)
	{
		super(parent,title,Model);
		lid=new Label("ID");
		lnm=new Label("Name");
		lfee=new Label("Fee");

		ls=new LinkedList<String[]>();
		db=new DataTable(null,"Test Data",true);

		tid=new TextField(5);
		tnm=new TextField(20);
		tfee=new TextField(6);

		tid.addFocusListener(this);
		tnm.addFocusListener(this);
		tfee.addFocusListener(this);

		p1=new Panel();
		p1.setLayout(new GridLayout(3,2,5,5));
		p1.add(lid);
		p1.add(tid);
		p1.add(lnm);
		p1.add(tnm);
		p1.add(lfee);
		p1.add(tfee);

		bu=new Button("Update");
		bd=new Button("Dispaly");
		bb=new Button("Back");

		bu.addActionListener(this);
		bd.addActionListener(this);
		bb.addActionListener(this);

		p2=new Panel();
		p2.add(bu);
		p2.add(bd);
		p2.add(bb);

		add(p1);
		add(p2,"South");
		setSize(300,300);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				setVisible(false);
			}
		});
		rs=null;
		ps=null;
		id=0;fee=0;
		nm="";
		action="";
		setVisible(true);
	}
	public void setTitle(String p)
	{
		action=p;
		setTitle("Test"+p);
	}
	public void fieldToVariable()throws Exception
	{
		id=Integer.parseInt(tid.getText());
		nm=tnm.getText();
		fee=Integer.parseInt(tfee.getText());
	}
	public void variableToField()
	{
		id=0;fee=0;
		nm="";
		tid.setText(""+id);
		tnm.setText("");
		tfee.setText(""+fee);
	}
	public void variableToField(ResultSet p)throws Exception
	{
		id=p.getInt(1);
		nm=p.getString(2);
		fee=p.getInt(3);

		tid.setText(""+id);
		tnm.setText(""+nm);
		tfee.setText(""+fee);
	}
	public void focusGained(FocusEvent e)
	{
		TextField t=(TextField)e.getSource();
		if(t==tid)
		{
			variableToField();
			bu.setEnabled(false);
		}
	}
	public void focusLost(FocusEvent e)
	{
		TextField t=(TextField)e.getSource();
		if(t==tfee)
		{
			bu.setEnabled(true);
			return;
		}
		if(t==tid)
		{
			try
			{
				id=Integer.parseInt(tid.getText());
				ps=DMD.pts;
				ps.setInt(1,id);
				rs=ps.executeQuery();
				res=rs.next();
				if(res==true)
				{
					if(action.equals("add"))
					{
						tid.requestFocus();
						variableToField(rs);
						return;
					}
					
					else
					{
						if(!action.equals("add"))
						{
							tid.requestFocus();
							variableToField();
							return;
						}
					}
				}				
			}
			catch(Exception e33){}
		}

	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==bb)
			{setVisible(false);return;}
		try
		{
			if(b==bd)
			{
				resultSetToList();
				db.update(ls);
				db.setVisible(true);
			}
		}
		catch(Exception eu){}
		if(b==bu)
		{
			try
			{
				fieldToVariable();
				if(action.equals("add"))
				{
					ps=DMD.pti;
					ps.setInt(1,id);
					ps.setString(2,nm);
					ps.setInt(3,fee);
					ps.setBoolean(4,true);
					ps.executeUpdate();
				
				}
			}
			catch(Exception eee){}
			if(action.equals("mod"))
			{
				try
				{
					ps=DMD.ptm;
					ps.setString(1,nm);
					ps.setInt(2,fee);
					ps.setInt(3,id);
					ps.executeUpdate();
				}
				catch(Exception e7){}
			}
			if(action.equals("del"))
			{
				try
				{
					ps=DMD.ptd;
					ps.setInt(1,id);
					ps.executeUpdate();
				}
				catch(Exception  e7){}
			}
			variableToField();
			tid.requestFocus();

		}
	}
	public void resultSetToList()
	{
		int i=0,n=0;
		boolean res=false;
		ls=new LinkedList<String[]>();
		ps=DMD.ptdisplay;
		try
		{
			rs=ps.executeQuery();
			res=rs.next();
			if(res==false)
				return;

			while(res)
			{
				ls.add(new String[]{""+rs.getInt(1),""+rs.getString(2),""+rs.getString(3),""+rs.getBoolean(4)});
				res=rs.next();
			}

		}
		catch(Exception ee){}
	}
}