import java.io.*;
import java.net.*;
class ThreadCommunication1 extends Thread
{
	ServerSocket ss;
	Socket s;
	DataOutputStream dos;
	BufferedReader br;
	DataInputStream dis;
	String str,cnm;

	ThreadCommunication1(Socket st)
	{
		super();
		s=st;
		try
		{
		dos=new DataOutputStream(s.getOutputStream());
		dis=new DataInputStream(s.getInputStream());
		br=new BufferedReader(new InputStreamReader(System.in));
		cnm=dis.readUTF();
		start();
		}
		catch(Exception er){}
	}
	public void run()
	{
		doChat();
	}
	synchronized void doChat()
	{
		try
		{
			while(true)
			{
				System.out.println("Message to "+cnm+":");
				str=br.readLine();	
				dos.writeUTF(str);		
				
				if(str.equalsIgnoreCase("bye"))
					break;
				
				str=dis.readUTF();
				dos.writeUTF(str);
				System.out.println("Message from"+cnm+":"+str);
				if(str.equalsIgnoreCase("bye"))
					break;
			}
		}
		catch(Exception eee){}
	}

}