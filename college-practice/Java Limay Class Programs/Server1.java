import java.net.*;
import java.io.*;
class Server1
{
	public static void main(String []args)
	{
		ServerSocket ss=null;
		Socket s=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		try
		{
			ss=new ServerSocket(8086);
			System.out.println("Server Started");
			s=ss.accept();
			dos=new DataOutputStream(s.getOutputStream());
			dis=new DataInputStream(s.getInputStream());

			String str=dis.readUTF();
			System.out.println("Message from Client "+str);
			str="WelCome";
			dos.writeUTF(str);
			dos.close();
			dis.close();
			s.close();
			ss.close();
		}
		catch(Exception e){}

	}
}