import Arraypkg.DS0;
import mypkg.Util;
class UseDS0
{
	public static void main(String []args)
	{
		DS0 o=new DS0();
		String[]op={"Stack","Queue","Exit"};
		int r=Util.iOption("Data Structure\n",op);
		if(r==2)
			return;
		else if(r==0)
			o.smenu();
		else
			o.qmenu();
	}
}