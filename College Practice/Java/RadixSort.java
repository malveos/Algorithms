import java.io.*;
import java.util.*;

class RadixSort
{
	static int getMax(int arr[],int n)
	{
		int max=arr[0];
		for(int i=0;i<n;i++)
			if(arr[i]>max)
				max=arr[i];
			
		return max;	
	}
	public static void rsort(int arr[],int n)
	{
		int m=getMax(arr,n);
		for(int i=1;m/i>0;i*=10)
			cntsort(arr,n,i);
	}
	static void cntsort(int arr[],int n,int exp)
	{
		int count[]=new int[10];
		int op[]=new int[n];
		int i=0;
		
		Arrays.fill(count,0);
		for(i=0;i<n;i++)
			count[(arr[i]/exp)%10]++;
		System.out.println("count arr");
		for(i=0;i<10;i++)
				System.out.println(count[i]);	//storing unit place values in count array
		for(i=1;i<10;i++)
			count[i]+=count[i-1];
		System.out.println("after i-1 count arr");
		for(i=0;i<10;i++)
				System.out.println(count[i]);
		for(i=n-1;i>=0;i--)
			op[--count[(arr[i]/exp)%10]]=arr[i];
		
		for(i=0;i<n;i++)
			arr[i]=op[i];
	}
	static int  ar1[];
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		 ar1=new int [n];
		 //ar2=new int [n];
		for(int i=0;i<n;i++)
		{
			ar1[i]=sc.nextInt();
			//ar2[i]=sc.nextInt();
		}
		rsort(ar1,n);
		
		for(int i=0;i<n;i++)
		{
			System.out.println(ar1[i]);
		}
	}
}