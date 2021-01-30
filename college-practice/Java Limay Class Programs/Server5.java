import java.io.*;
import java.net.*;
import java.util.*;

class Server5 implements Runnable
{
	public void run()
	{
		int i=0;
		String str="";
		while(true)
		{
			System.out.println("Message To Client");
			
			try
			{
				str=br.readLine();
				for(i=0;i<ls.size();i++)
				{
					DataOutputStream dos=ls.get(i);
					dos.writeUTF(str);
				}
			}
			catch(Exception ee){}
			System.out.println(":"+str);
			if(str.equals("Bye"))
				break;
		}
	}
	Server5()
	{
		try
		{
			ss=new ServerSocket(8090);
			br=new BufferedReader(new InputStreamReader(System.in));
			ls=new LinkedList<DataOutputStream>();
		}
		catch(Exception tt){}
		th=new Thread(this);
		th.start();
		WaitForClient();
		
	}
	void WaitForClient()
	{
		while(true)
		{
			try
			{
				s=ss.accept();
				dos=new DataOutputStream(s.getOutputStream());
				ls.add(dos);
			}
			catch(Exception ty){}
		}
	}
	public static void main(String []args)
	{
		Server5 ff=new Server5();
	}
	ServerSocket ss;
	Socket s;
	DataOutputStream dos;
	BufferedReader br;
	static LinkedList <DataOutputStream>ls;
	Thread th;
}