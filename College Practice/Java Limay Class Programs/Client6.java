import java.io.*;
import java.net.*;
class Client6
{
	
	Socket s;
	DataOutputStream dos;
	BufferedReader br; 
	DataInputStream dis;
	String str,cnm;

	Client6(String nm)
	{
		cnm=nm;
		try
		{
			s=new Socket("localhost",3031);
			dos=new DataOutputStream(s.getOutputStream());
			dis=new DataInputStream(s.getInputStream());
			br=new BufferedReader(new InputStreamReader(System.in));
			dos.writeUTF(cnm);
			doChat();
		}
		catch(Exception e){}
	}
	void doChat()
	{
		while(true)
		{
			try
			{
				str=dis.readUTF();			//reads from server
				System.out.println("Message from server:"+str);
				if(str.equalsIgnoreCase("bye"))
					break;
				System.out.println("Message to server:");
				str=br.readLine();
				dos.writeUTF(str);
				if(str.equalsIgnoreCase("bye"))
					break;
			}
			catch(Exception ee){}
		}
	}
	public static  void main(String []args)
	{
		if(args.length!=1)
			return;
		Client6 v=new Client6(args[0]);
	}
}