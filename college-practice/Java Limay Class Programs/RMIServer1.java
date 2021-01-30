import java.rmi.*;
import java.rmi.server.*;

interface iRMI extends Remote
{
	public int getNumber(int a) throws RemoteException;
}

class iRMIImpl extends UnicastRemoteObject implements iRMI
{
	iRMIImpl() throws RemoteException
	{super();}
	public int getNumber(int a)
	{
		int no=(int)(Math.random()*a);
		return no;
	}
}

class RMIServer1
{
	public static void main(String[] args) {
		try
		{
			iRMIImpl aobj = new iRMIImpl();
			System.out.println("Mainsdjab");
			Naming.rebind( "WC" , aobj);
			System.out.println("Server started");
		}
		catch(Exception e){System.out.println(e);}
		System.out.println("Main ends");
	}
}