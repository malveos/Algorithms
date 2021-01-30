import java.io.*;
import java.util.*;

class MergeSort
{
	public static void srt(int ar[],int ar2[],int l ,int h)
	{
		int p=0;
		if(l==h)
		return;
		
			p=l+(h-l)/2;
			srt(ar,ar2,l,p);
			srt(ar,ar2,p+1,h);
			mg(ar,ar2,l,p,h);
		
	}
	public static void mg(int ar[],int ar2[],int l,int m,int r)
	{
		int i=l,j=m+1,k=l;
		int tp[]=new int[ar.length];int tp2[]=new int[ar.length];
		for(int x=l;x<=r;x++)
		{tp[x]=ar[x];
			tp2[x]=ar2[x];}
		
		while(i<=m &&j<=r)
		{
			if(tp[i]<=tp[j])
			{
				ar[k]=tp[i];
				ar2[k]=tp2[i];
				i++;
			}	
			else
			{
				ar[k]=tp[j];
				ar2[k]=tp2[j];
				j++;
			}
			k++;
		}
		while(i<=m)
		{ar[k]=tp[i];
			ar2[k]=tp2[i];k++;i++;}
	}
	
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		 int ar[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			ar[i]=sc.nextInt();
		}
		int ar2[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			ar2[i]=sc.nextInt();
		}
		srt(ar,ar2,0,n-1);
		System.out.println();
		for(int i=0;i<n;i++)
		{System.out.println(ar[i]+" "+ar2[i]);}
	}
}