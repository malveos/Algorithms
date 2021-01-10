import java.io.*;
import java.net.*;
class Client5
{
	public static void main(String []args)throws Exception
	{
		Socket s=new Socket("localhost",8090);
		DataInputStream dis=new DataInputStream(s.getInputStream());
		String str="";
		while(true)
		{
			str=dis.readUTF();
			if(str.equals("Bye"))
				break;
			System.out.println("Message From Server:\t"+str);

		}
		dis.close();
		s.close();
	}
}