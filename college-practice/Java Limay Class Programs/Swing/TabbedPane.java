import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class JPanel1 extends JPanel implements ActionListener
{
	JLabel l1,l2;
	JButton b1,b2;
	JTextField t1,t2;
	JPanel1()
	{
		super();
		l1=new JLabel("Roll No:");
		l2=new JLabel("Name:");
		t1=new JTextField(30);
		t2=new JTextField(30);
		b1=new JButton("OK");
		b2=new JButton("CANCEL");
		b1.addActionListener(this);
		b2.addActionListener(this);

		setLayout(new GridLayout(3,2,5,5));
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b1);
		add(b2);
		setSize(300,300);
		setOpaque(false);
		//setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton b=(JButton)e.getSource();
		if(b==b1)
		{
			String s="Roll No:"+t1.getText()+"\nName:"+t2.getText();
			JOptionPane.showMessageDialog(null,s);

		}
		t1.setText("");
		t2.setText("");
		t1.requestFocus();
	}
}
class JPanel2 extends JPanel
{
	JList c;
	String s[]={"Nanded","Udgir","Sangli","Pune"};
	JPanel2()
	{
		super();
		c=new JList(s);
		c.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				int i=c.getSelectedIndex();
				if(i!=-1)
				{
					JOptionPane.showMessageDialog(null,c.getSelectedValues());
				}
			}
		});
		add(c);
		setSize(500,500);
		setOpaque(false);
		//setVisible(true);
	}
}

class JPanel3 extends JPanel implements ActionListener
{
	JPanel p1,p2;
	JButton  b1,b2;
	JLabel l1,l2;
	ButtonGroup bg1,bg2;
	JRadioButton y1,y2,y3,y4,t1,t2,t3,t4,t5,t6;
	String s;

	JPanel3()
	{
		super();
		l1=new JLabel("Year");
		p1=new JPanel();
		bg1=new ButtonGroup();
		y1=new JRadioButton("I");
		y2=new JRadioButton("II");
		y3=new JRadioButton("III");
		y4=new JRadioButton("IV");
		bg1.add(y1);
		bg1.add(y2);
		bg1.add(y3);
		bg1.add(y4);

		p1.add(y1);
		p1.add(y2);
		p1.add(y3);
		p1.add(y4);
		add(p1);

		l2=new JLabel("Trade");
		p2=new JPanel();
		bg2=new ButtonGroup();
		t1=new JRadioButton("cse");
		t2=new JRadioButton("it");
		t3=new JRadioButton("civil");
		t4=new JRadioButton("mech");
		t5=new JRadioButton("electrical");
		t6=new JRadioButton("electronics");

		bg2.add(t1);
		bg2.add(t2);
		bg2.add(t3);
		bg2.add(t4);
		bg2.add(t5);
		bg2.add(t6);

		p2.add(t1);
		p2.add(t2);
		p2.add(t3);
		p2.add(t4);
		p2.add(t5);
		p2.add(t6);
		add(p2);

		b1=new JButton("OK");
		b2=new JButton("CANCEL");
		b1.addActionListener(this);
		b2.addActionListener(this);

		add(b1);
		add(b2);

		setSize(300,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton k=(JButton)e.getSource();
		String s="YEAR:";
		if(k==b1)
		{
			Component []cy=p1.getComponents();
			for(Component p:cy)
			{
				JRadioButton b=(JRadioButton)p;
				if(b.isSelected())
					s=s+" "+b.getLabel();
			}
			s+="\nTRADE:";
			cy=p2.getComponents();
			for(Component p:cy)
			{
				JRadioButton b=(JRadioButton)p;
				if(b.isSelected())
					s=s+" "+b.getLabel();
			}
			JOptionPane.showMessageDialog(null,s);
		}
	}
}
class TabbedPane extends JFrame
{
	JPanel1 j1;
	JPanel2 j2;
	JPanel3 j3;
	JTabbedPane pan;
	TabbedPane()
	{
		super("TabbedPane");
		j1=new JPanel1();
		j2=new JPanel2();
		j3=new JPanel3();
		pan=new JTabbedPane();
		pan.add("Student",j1);
		pan.add("City",j2);
		pan.add("Department",j3);

		Container con=getContentPane();
		con.add(pan);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		//setOpaque(false);
		setVisible(true);
	}
	public static void main(String []args)
	{
		TabbedPane x=new TabbedPane();
	}
}
