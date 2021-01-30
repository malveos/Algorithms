import java.io.*;
import mypkg.Util;
class RBSdata
{
	public static void main(String []args)throws Exception
	{
		FileInputStream fis=new FileInputStream("number.dat");
		int no=0;
		while(true)
		{
			no=fis.read();
			if(no==-1)
				break;
			System.out.println(no);
		}
		fis.close();
	}
}