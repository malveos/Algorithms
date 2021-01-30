import java.util.*;
class CustomizedSorting
{
	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new mycom());
		ts.add("omkar");
		ts.add("vikas");
		ts.add("anurag");
		ts.add("vishal");
		ts.add("patil");
		System.out.println("Elements:"+ts);
	}
}
class mycom implements Comparator
{
	public int compare(Object ob1,Object ob2)
	{
		String i=(String)ob1;
		String j=(String)ob2;
		return j.compareTo(i);	
	}
}