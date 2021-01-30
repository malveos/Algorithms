import java.io.*;
import mypkg.Util;
class RPDFromFile
{
	public static void main(String []args)
	{
		int no=0;String nm="";double mrk=0.0;
		FileInputStream fis=null;
		DataInputStream dis=null;
		try
		{
			 fis=new FileInputStream("stu.dat");
			 dis=new DataInputStream(fis);
		}
		catch(Exception e){}
		while(true)
		{
			try{
				no=dis.readInt();
				nm=dis.readUTF();
				mrk=dis.readDouble();
			}
			catch(Exception e){break;}
			
			String s="Student data::\nRoll no:"+no+"\nName:"+nm+"\nMarks:"+mrk;
			Util.display(s);
		}
		try
		{
			dis.close();
			fis.close();
		}
		catch(Exception e){}
		
	}
}