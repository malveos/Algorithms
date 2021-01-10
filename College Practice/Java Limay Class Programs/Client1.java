import java.net.*;
import java.io.*;
class Client1
{
	public static void main(String []args)
	{
		Socket s=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		String str;
		try
		{
			s=new Socket("localhost",8086);
			dos=new DataOutputStream(s.getOutputStream());
			dis=new DataInputStream(s.getInputStream());

			str="Hi";
			dos.writeUTF(str);
			str=dis.readUTF();
			System.out.println("Message from Server "+str);
			
			
			dos.close();
			dis.close();
			s.close();
		}
		catch(Exception e){}
	}
}