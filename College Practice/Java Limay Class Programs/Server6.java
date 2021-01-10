import java.io.*;
import java.net.*;

class Server6
{
	public static void main(String []args)
	{
		try
		{
			ServerSocket ss=new ServerSocket(3031);
			while(true)
			{
				Socket s=ss.accept();
				new ThreadCommunication1(s);
			}
		}
		catch(Exception eee){}
	}
}