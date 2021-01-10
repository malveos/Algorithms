import javax.swing.*;
import mypkg.City;
import java.util.*;
import mypkg.Util;
class UseCity
{
	public static void main(String []args)
	{
		LinkedList<City>ls=new LinkedList<City>();
		while(true)
		{
			int id=Util.iInput("Enter id");
			if(id<=0){continue;}
			
			City o=new City();
			o.setData(id);
			ls.add(o);
			if(Util.iQuery("Continue????")==JOptionPane.NO_OPTION)
				break;
		}
		for(City p:ls)
			p.display();
	}

	
	