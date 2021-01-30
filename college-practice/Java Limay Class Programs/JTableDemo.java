import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JTableDemo extends JFrame
{
	JTable obj;
	JTableDemo()
	{
		super("student table");
		String cnm[]={"Rollno","Name","Trade","Marks"};
		Object [][]arr={{new Integer(1),"sushant","cse",new Double(8.2)},
						{new Integer(2),"ravi","cse",new Double(5.5)},
						{new Integer(3),"smriti","mech",new Double(7.0)},
						{new Integer(4),"suraj","civil",new Double(8.8)},
						{new Integer(5),"suresh","it",new Double(8.4)}};
		obj=new JTable(arr,cnm);
		obj.setPreferredScrollableViewportSize(new Dimension(500,100));
		obj.setFillsViewportHeight(true);
		JScrollPane jsp=new JScrollPane(obj);
		Container con=getContentPane();
		con.setLayout(new FlowLayout());
		con.add(jsp);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,200);
		setVisible(true);				
	}
	public static void main(String[] args) {
		JTableDemo x=new JTableDemo();
	}
}
