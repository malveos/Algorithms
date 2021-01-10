import java.net.*;
import java.io.*;
class Server2
{
	public static void main(String []args)
	{
		ServerSocket ss=null;
		Socket s=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		BufferedReader br=null;
		String str="";
		try
		{
			ss=new ServerSocket(3000);
			System.out.println("Server Started");
			s=ss.accept();
			dos=new DataOutputStream(s.getOutputStream());
			dis=new DataInputStream(s.getInputStream());
			br=new BufferedReader(new InputStreamReader(System.in));

			
		}
		catch(Exception e){}
		try
			{
		while(true)
		{
			str=dis.readUTF();
			System.out.println("Message from Client "+str);
			//str="WelCome";
			if(str.equals("Bye"))
			break;

			System.out.println("Message to Client:");
			str=br.readLine();
			dos.writeUTF(str);
			if(str.equals("Bye"))
			break;
		}
			
				dos.close();
				dis.close();
				s.close();
				ss.close();
				}
				catch(Exception ee){}
		
	}
}