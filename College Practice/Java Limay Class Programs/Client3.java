import java.net.*;
import java.io.*;
class Client3
{
	public static void main(String []args)throws Exception
	{
		Socket s=new Socket("localhost",3000);;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		BufferedReader br=null;
		String str="";
		
			
			dos=new DataOutputStream(s.getOutputStream());
			dis=new DataInputStream(s.getInputStream());
			br=new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter file name");
		String snm=br.readLine();

		dos.writeUTF(snm);
		int res=dis.readInt();

		if(res==0)
		{
			System.out.println("File not found");
			dos.close();
			dis.close();
			s.close();
			
			return;

		}
		System.out.println("Enter file name");
		String dnm=br.readLine();
		FileOutputStream fos=new FileOutputStream(dnm);

		byte []b=new byte[500];
		
		while(true)
		{
			
			int len=dis.read(b);
			if(len==-1)
				break;
			fos.write(b);
		}
		
			    dos.close();
				dis.close();
				s.close();
				fos.close();
		
	}
}