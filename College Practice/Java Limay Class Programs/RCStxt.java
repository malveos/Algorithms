import java.io.*;
class RCStxt
{
	public static void main(String []args)throws Exception 
	{
		File f=new File("abc.txt");
		int val=0;
		if(!f.exists())
		{
			System.out.println("FILE NOT FOUND!!!!!!!!");
			return;
		}
		FileReader fr=new FileReader(f);
		while(true)
		{
			val=fr.read();
			if(val==-1)
				break;
			System.out.println((char)val);
		}
		fr.close();
	}
}