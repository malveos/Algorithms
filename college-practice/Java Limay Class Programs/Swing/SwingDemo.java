import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SwingDemo extends JFrame implements ActionListener
{
	JLabel lnm;
	JTextField tnm;
	JButton bok;
	Button bbb;
	SwingDemo()
	{
		super("Swing app");
		lnm=new JLabel("Name");
		tnm=new JTextField(30);
		bok=new JButton("OK");
		bbb=new Button("Simple");
		bok.addActionListener(this);

		Container cobj=getContentPane();
		cobj.setLayout(new FlowLayout());

		cobj.add(lnm);
		cobj.add(tnm);
		cobj.add(bok);
		cobj.add(bbb);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setSize(300,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null,tnm.getText());
	}
	public static void main(String []args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new SwingDemo();
			}
		});
	}
}