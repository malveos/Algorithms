import java.io.*;
import java.util.*;

class QuickSort
{
	public static int ar1[],ar2[];
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		 ar1=new int [n];
		 ar2=new int [n];
		for(int i=0;i<n;i++)
		{
			ar1[i]=sc.nextInt();
			ar2[i]=sc.nextInt();
		}
		qs(ar1,ar2,0,n-1);
		
		for(int i=0;i<n;i++)
		{
			System.out.println(ar1[i]+" "+ar2[i]);
		}
	}
	public static void qs(int ar1[],int ar2[],int l,int h)
	{
		int i=l,j=h;
		int pv=ar1[l+(h-l)/2];
		
		while(i<=j)
		{
			while(ar1[i]<pv)
				i++;
			while(ar1[j]>pv)
				j--;
			if(i<=j)
			{
				swap(i,j);
				i++;
				j--;
			}
		}
		if(l<j)
			qs(ar1,ar2,l,j);
		if(i<h)
			qs(ar1,ar2,i,h);
	}
	public static void swap(int a,int b)
	{
		int tp=0;
		tp=ar1[a];
		ar1[a]=ar1[b];
		ar1[b]=tp;

			tp=ar2[a];
		ar2[a]=ar2[b];
		ar2[b]=tp;
	}
}