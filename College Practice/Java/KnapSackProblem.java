import java.io.*;
import java.util.*;

class KnapSackProblem
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter  total no");
	
	int n=sc.nextInt();
	int profit[]=new int[n];
	int weight[]=new int[n],i=0,tp=0;
	
	System.out.println("Enter profit and weight alternatively::");
	for(i=0;i<n;i++)
	{
		profit[i]=sc.nextInt();
		weight[i]=sc.nextInt();
	}

	System.out.println("Enter Capacity");
	int M=sc.nextInt();
	double p=0.0;

	for(i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(profit[j]<profit[j+1])
				{
					tp=profit[j];profit[j]=profit[j+1];profit[j+1]=tp;
					tp=weight[j];weight[j]=weight[j+1];weight[j+1]=tp;
				}
			}
		}
	for(i=0;i<n;i++)
	{
		if(weight[i]<=M)
		{
			p+=(double)profit[i];
			M-=weight[i];
		}
		else
			break;
	}
	if(i<=n)
	{
		p+=(double)M/weight[i]*profit[i];
	}
	
	System.out.println("Max profit:"+p);
	}
}