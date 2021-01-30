package mypkg;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
public class NTF extends TextField
{
	String str;
	int no;
	
	public NTF(int n)
	{
		super(n);
		str=new String();
		
		addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if((e.getKeyChar()>='0'&&e.getKeyChar()<='9')||e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
					setEditable(true);
				else
					setEditable(false);
			}
		});
	}
	public int getNumber()
	{
		try
		{
			str=getText();
			no=Integer.parseInt(str.trim());	
			

		}
		catch(Exception e){}
		return no;
	}
	
	public String toString(){return new String("Number:"+no);};

}
