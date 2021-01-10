import javax.swing.*;
import mypkg.Util;

class UseUtil
{
	public static void main(String []args)
	{
		while(true)
		{
			int i=Util.iInput("Roll no");
			double d=Util.dInput("Marks");
			String nm=Util.sInput("Name");
			
			String s="\nStudent\nRoll no:"+i+"\nName:"+nm+"\nMarks:"+d;
			
			Util.display(s);
			
			int opt=Util.iQuery("Continue?");
			if(opt==JOptionPane.NO_OPTION||opt==JOptionPane.CANCEL_OPTION)
				break;
		}
	}
}