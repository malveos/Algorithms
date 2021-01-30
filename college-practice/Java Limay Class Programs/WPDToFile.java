import java.io.*;
import mypkg.Util;
class WPDToFile
{
	public static void main(String []args)throws Exception
	{
		int no=0;String nm="";
		double mrk=0.0;
		DataOutputStream dos=new DataOutputStream(new FileOutputStream("stu.dat"));
		while(true)
		{
			no=Util.iInput("Roll no:");
			if(no==0)
				break;
			nm=Util.sInput("Name:");
			mrk=Util.dInput("Marks:");
			
			
			dos.writeInt(no);
			dos.writeUTF(nm);
			dos.writeDouble(mrk);
		}
		dos.close();
	}
}