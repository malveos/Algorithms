import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
class Panel1 extends JPanel implements ActionListener
{
	JRadioButton b1,b2,b3;
	Container con;
	Panel1(Container a)
	{
		super();
		con=a;
		add(new JButton("Button"));
		add(new JLabel("Label"));
		add(new JTextField("TextField"));
		add(new JCheckBox("CheckBox"));
		add(new JRadioButton("JRadioButton"));
		add(new JList(new String[]{"str1","str2","str3"}));
		add(new JScrollBar(SwingConstants.HORIZONTAL));
		
		b1=new JRadioButton("Metal");
		b2=new JRadioButton("Motif");
		b3=new JRadioButton("Windows");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		ButtonGroup b=new ButtonGroup();
		b.add(b1);
		b.add(b2);
		b.add(b3);

		add(b1);
		add(b2);
		add(b3);
		setOpaque(false);

	}	
	public void actionPerformed(ActionEvent e)
	{
		JRadioButton bb=(JRadioButton)e.getSource();
		if(bb==b1)
		{
			try
			{
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			}
			catch(Exception e1){}
		}
		if(bb==b2)
		{
			try
			{
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			}
			catch(Exception e2){}
		}
		if(bb==b3)
		{
			try
			{
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			}
			catch(Exception e22){}
		}
		SwingUtilities.updateComponentTreeUI(con);
	}
}
class LookAndFeel extends JFrame
{
	Panel1 pan;
	LookAndFeel()
	{
		super("Pluggable LookAndFeel");
		Container c=getContentPane();
		pan=new Panel1(c);
		add(pan);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,400);
		setVisible(true);
	}
	public static void main(String[]args)
	{
		LookAndFeel x=new LookAndFeel();
	}
}
