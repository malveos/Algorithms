import javax.swing.*;
import mypkg.Util;
import java.util.*;
import mypkg.Student;
class UseStudent1
{
	public static void main(String []args)
	{
		LinkedList<Student>ls=new LinkedList<Student>();
		int n=1;
		while(true)
		{
			Student s=new Student();
			s.setData(n);
			ls.add(s);
			int res=Util.iQuery("Continue??");
			if(res==JOptionPane.NO_OPTION)
				break;
			n++;
		}
		for(Student s:ls)
			s.display();
	}
} 