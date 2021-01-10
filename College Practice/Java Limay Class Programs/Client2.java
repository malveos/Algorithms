import java.net.*;
import java.io.*;
class Client2
{
	public static void main(String []args)
	{
		Socket s=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		BufferedReader br=null;
		String str="";
		try
		{
			s=new Socket("localhost",3000);
			dos=new DataOutputStream(s.getOutputStream());
			dis=new DataInputStream(s.getInputStream());
			br=new BufferedReader(new InputStreamReader(System.in));

			str="";
		}
		catch(Exception e){}
		try
		{
		while(true)
		{
			
			System.out.println("Message from Server ");
			str=br.readLine();
			dos.writeUTF(str);
			if(str.equals("Bye"))
			break;
			str=dis.readUTF();
			System.out.println("Message From Server:"+str);
			
			if(str.equals("Bye"))
			break;
		}
		
			    dos.close();
				dis.close();
				s.close();
		}
		catch(Exception rt){}
	}
}