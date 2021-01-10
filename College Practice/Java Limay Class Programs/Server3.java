import java.net.*;
import java.io.*;
class Server3
{
	public static void main(String []args) throws Exception
	{
		ServerSocket ss=new ServerSocket(3000);;
		Socket s=ss.accept();
		DataOutputStream dos=null;
		DataInputStream dis=null;
		BufferedReader br=null;
		String str="";
		
			
			System.out.println("Server Started");
			
			dos=new DataOutputStream(s.getOutputStream());
			dis=new DataInputStream(s.getInputStream());
			br=new BufferedReader(new InputStreamReader(System.in));


		String fnm=dis.readUTF()	;
		File f=new File(fnm);
		int res=0;
		if(f.exists())
			res=1;
		else
			res=0;
		dos.writeInt(res);
		if(res==0)
		{
			dos.close();
				dis.close();
				s.close();
				ss.close();
				return;

		}
		FileInputStream fis=new FileInputStream(f);
		byte []b=new byte[500];int len=0;
		while(true)
		{
			len=fis.read(b);
			if(len==-1)
				break;
			dos.write(b);
		}
		fis.close();
		
		
			System.out.println("File copying completed");
			
			
				dos.close();
				fis.close();
				dis.close();
				s.close();
				ss.close();
				
		
	}
}