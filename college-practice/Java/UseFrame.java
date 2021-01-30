import java.awt.*;
import java.awt.event.*;
import java.applet.*;
class UseFrame extends Frame implements ActionListener
{
	TextField txt;
	TryFrame()
	{
		super();
		txt=new TextField(5);
		txt.setText(0+"");
		Button b=new Button("count");
		b.addActionListener(this);
		
		setLayout(new GridLayout(2,2,5,5));
		add(txt);add(b);
		setSize(400,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		txt.setText(Integer.parseInt(txt.getText())+1+"");
	}	
	public static void main(String [] args)
	{
	 	TryFrame fr=new TryFrame();
	}
}