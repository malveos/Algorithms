package mypkg;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import java.util.Date;
public class DoubleTF extends TextField
{
	String str;
	double no;
	
	public DoubleTF(int n)
	{
		super(n);
		str=new String();
		
		addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if((e.getKeyChar()>='0'&&e.getKeyChar()<='9')||e.getKeyCode()=='.'||e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
					setEditable(true);
				else
					setEditable(false);
			}
		});
	}
	public void focusLost(FocusEvent e)
	{
		TextField t=(TextField)e.getSource();
		str=getText();
		JOptionPane.showMessageDialog(null,str);
		String ss="(.+).(.+)";
			if(!str.matches(ss))
			{			
				setText("");
				requestFocus();	
			}
	}
	public double getDouble()
	{
		try
		{
			str=getText();//"(.*)@(.*).com"
			
				no=Double.parseDouble(str.trim());
			
			

		}
		catch(Exception e){}
		return no;
	}
	
	public String toString(){return new String("Double:"+no);};

}
