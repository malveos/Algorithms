import java.util.*;
class UseGC
{
	public static void main(String[] args) {
		Runtime r=Runtime.getRuntime();
		System.out.println("Total Memory:\t"+r.totalMemory()/(1024.0*1024));
		System.out.println("Free Memory:\t"+r.freeMemory()/(1024.0*1024));

		for(int i=0;i<100000;i++)
		{
			Date d=new Date();
			d=null;
		}
		System.out.println("Free Memory:\t"+r.freeMemory()/(1024.0*1024));

		r.gc();
		System.out.println("Free Memory:\t"+r.freeMemory()/(1024.0*1024));
	}
}