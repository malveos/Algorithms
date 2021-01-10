import java.io.*;

class WCStxt
{
	public static void main(String []args)throws Exception
	{
		FileWriter fw=new FileWriter("abc.txt");
		int val=0;
		while(true)
		{
			System.out.println("Enter char");
			val=System.in.read();
			System.in.skip(3);
			if((char)val=='*')
				break;
			
			fw.write(val);
			
			
		}
		fw.close();
	}
}