import java.rmi.*;
import java.rmi.server.*;
class RMIClient1
{
	public static void main(String[] args) {
		try
		{
			String url="rmi://localhost/WCE1";
			iRMI iref=(iRMI)Naming.lookup(url);
			System.out.println("No:"+iref.getNumber(100));
		}
		catch(Exception e){}
	}

}
