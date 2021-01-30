import java.awt.*;
import java.awt.event.*;
import mypkg.Util;
class GridBagLayoutDemo extends Frame
{
	Panel pan;
	GridBagConstraints c;
	GridBagLayoutDemo()
	{
		super("demo");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});
		pan=new Panel();
		pan.setLayout(new GridBagLayout());
		c=new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);

		c.gridx=0;
		c.gridy=0;
		c.gridwidth=c.gridheight=4;
		c.weightx=c.weighty=1.0;
		pan.add(new Button("B1"),c);

		c.gridx=4;
		c.gridy=0;
		c.gridwidth=c.gridheight=1;
		c.weightx=c.weighty=0.0;
		pan.add(new Button("B2"),c);

		
		c.gridx=4;
		c.gridy=1;
		c.gridwidth=c.gridheight=1;
		c.weightx=c.weighty=0.0;
		pan.add(new Button("B3"),c);

		c.gridx=4;
		c.gridy=2;
		c.gridwidth=1;c.gridheight=2;
		c.weightx=c.weighty=0.0;
		pan.add(new Button("B4"),c);

		c.gridx=0;
		c.gridy=4;
		c.gridwidth=c.gridheight=1;
		c.weightx=c.weighty=0.0;
		pan.add(new Button("B5"),c);

		c.gridx=2;
		c.gridy=4;
		c.gridwidth=c.gridheight=1;
		pan.add(new Button("B6"),c);

		c.gridx=3;
		c.gridy=4;
		c.gridwidth=2;c.gridheight=1;
		pan.add(new Button("B7"),c);

		c.gridx=1;
		c.gridy=5;
		c.gridwidth=c.gridheight=1;
		pan.add(new Button("B8"),c);

		c.gridx=3;
		c.gridy=5;
		c.gridwidth=1;c.gridheight=1;
		pan.add(new Button("B9"),c);

		add(pan);
		setSize(400,400);
		setVisible(true);
	}
	public static void main(String []args)
	{
		GridBagLayoutDemo x=new GridBagLayoutDemo();
	}
}