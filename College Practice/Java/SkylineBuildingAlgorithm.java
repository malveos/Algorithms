import java.io.*;
import java.util.*;

class SkylineBuildingProblem
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		
		int b=sc.nextInt();
		int l[]=new int[b];
		int r[]=new int[b];
		int h[]=new int[b];
		int mx=0;
		for(int i=0;i<b;i++)
		{
			l[i]=sc.nextInt();
			r[i]=sc.nextInt();
			h[i]=sc.nextInt();
			if(mx<r[i])
				mx=r[i];
		}
		int m[]=new int[mx+1];
		
		for(int i=b-1;i>=0;i--)
		{
			for(int j=l[i];j<=r[i];j++)
			{
				if(m[j]<h[i])
					m[j]=h[i];
			}
		}
		for(int i=1;i<=mx;i++)
			System.out.println(i+" "+m[i]);
	}
}