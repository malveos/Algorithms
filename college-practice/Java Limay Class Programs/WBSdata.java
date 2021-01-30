import java.io.*;
import mypkg.Util;
class WBSdata
{
	public static void main(String []args)throws Exception
	{
		FileOutputStream fos=new FileOutputStream("number.dat");
		int no=0;
		while(true)
		{
			no=Util.iInput("Enter no:");
			if(no==0)
				break;
			fos.write(no);
		}
		fos.close();
	}
}