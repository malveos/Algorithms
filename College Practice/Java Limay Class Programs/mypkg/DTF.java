package mypkg;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
public class DTF extends TextField
{
	String str;
	int d,m,y;
	Date dt;
	DateFormat df;
	public DTF(int n)
	{
		super(n);
		str=new String();
		dt=null;
		df=new SimpleDateFormat("dd/M/yyyy");
		addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyChar()>='0'&&e.getKeyChar()<='9'||e.getKeyChar()=='/'||e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
					setEditable(true);
				else
					setEditable(false);
			}
		});
	}
	public Date getDate()
	{
		try
		{
			str=getText();
			dt=df.parse(str.trim());
			d=dt.getDate();
			m=dt.getMonth()+1;
			y=dt.getYear()+1900;

		}
		catch(Exception e){}
		return dt;
	}
	public int getDay(){return d;}
	public int getMonth(){return m;}
	public int getYear(){return y;}
	public String toString(){return new String("Date="+d+"/"+m+"/"+y);};

}
