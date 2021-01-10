import java.io.*;
import javax.swing.*;
class RPDFromFile
{
	public static void main(String []args)
	{
		int no=0;String nm="";double mrk=0.0;
		FileInputStream fis=null;
		DataInputStream dis=null;String s="";
		try
		{
			 fis=new FileInputStream("log.dat");
			 dis=new DataInputStream(fis);
		}
		catch(Exception e){}
		while(true)
		{
			try{
				//no=dis.readInt();
				nm=dis.readUTF();
				//mrk=dis.readDouble();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,s);break;}
			
			 s=nm;//"Student data::\nRoll no:"+"\nName:"+nm+"\nMarks:"+mrk;
			JOptionPane.showMessageDialog(null,s);
		}
		try
		{
			dis.close();
			fis.close();
		}
		catch(Exception e){}
		
	}
}