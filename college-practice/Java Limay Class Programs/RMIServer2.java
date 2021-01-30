import java.rmi.*;
import java.rmi.server.*;

interface iComp extends Remote
{
	public int comp(int a,int b,char c) throws RemoteException;
}

class iCompImpl extends UnicastRemoteObject implements iComp
{
	iCompImpl() throws RemoteException
	{super();}
	public int comp(int a,int b,char c)
	{
		int res=0;
		switch(c)
		{
			case '+':
					res=a+b;break;
			case '-':
					res=a-b;break;
			case '*':
					res=a*b;break;
			case '/':
					res=a/b;break;
		}
		return res;
	}
}

class RMIServer2
{
	public static void main(String[] args) {
		try
		{
			iCompImpl aobj = new iCompImpl();
			Naming.rebind( "comp" , aobj);
			System.out.println("Server started");
		}
		catch(Exception e){System.out.println(e);}
		System.out.println("Main ends");
	}
}