import java.rmi.*;
import java.io.*;
import java.rmi.server.*;
class RMIClient2
{
	public static void main(String[] args) {
		try
		{
			BufferedReader br=null;
			int a=0,b=0,c=0;
			char ch='+';
			String str="";
			iComp ref=null;
			String url="rmi://localhost/comp";
			
				ref=(iComp)Naming.lookup(url);
				br=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter v1");
				a=Integer.parseInt(br.readLine());
				System.out.println("Enter v2");
				b=Integer.parseInt(br.readLine());
				System.out.println("\nEnter operation");
				ch=(char)System.in.read();
				c=ref.comp(a,b,ch);
				System.out.println("Result:"+c);
		}
		catch(Exception e1){}
	}

}
