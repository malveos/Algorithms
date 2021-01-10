import java.io.*;
import mypkg.Util;
class CTF
{
	public static void main(String []args)throws Exception
	{
		FileReader fr=null;
		FileWriter fw=null;
		File f=new File("abc.txt");
		if(!f.exists())
		{
			Util.display("File not found");
			return;
		}
		
		fr=new FileReader(f);
		fw=new FileWriter("pqr.txt");
		int l=(int)f.length();
		char []ch=new char[l];
		fr.read(ch);
		fw.write(ch);
		fr.close();
		fw.close();
	}
}