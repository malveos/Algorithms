package mypkg;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.*;

public class DataTable extends Dialog implements ActionListener
{
	JTable jt;
	Button bp,bb;
	DefaultTableModel dtm;
	String []chead={"id","name","fees","state"};
	String [][]arr=null;

	public DataTable(Frame parent,String title,boolean model)
	{
		super(parent,title,model);
		dtm=new DefaultTableModel(arr,chead);
		jt=new JTable(dtm);
		Panel p=new Panel();
		Panel q=new Panel();
		p.add(new JScrollPane(jt));
		bp=new Button("PRINT");
		bb=new Button("BACK");
		bp.addActionListener(this);
		bb.addActionListener(this);

		q.add(bp);
		q.add(bb);
		add(p);
		add(q,"South");
		setSize(300,200);


	}
	public void update(LinkedList<String[]>ls)throws Exception
	{
		int i=0,n=dtm.getRowCount();
		while(--i>=0)
		{
			dtm.removeRow(n);

		}
		n=ls.size();
		while(i<n)
		{
			dtm.insertRow(i,(Object[])ls.get(i));
			i++;
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==bp)
		{
			try
			{
			jt.print();
			}
		catch(Exception ee){}
		}
		setVisible(false);
	}
}