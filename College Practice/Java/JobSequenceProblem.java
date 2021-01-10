import java.io.*;
import java.util.*;
// 1C Answer:maximum profit:			142
//  1B  Answer:maximum profit:			74
class JobSequenceProblem
{
	public static boolean checkfull(int arr[])
	{
		
		for( int i=0; i<arr.length;i++)
			if(arr[i]==0)
				return true;

		return false;	
	} 
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total jobs");
		int n = sc.nextInt();

		int deadline [] =new int [n];
		int profit [] = new int [n];
		int mincost = 0;

		for (int i=0 ;i<n; i++)
		{
			System.out.println("Enter deadline andd profit:");
			deadline[i]=sc.nextInt();
			profit[i] = sc.nextInt();

		}
		int tp=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(profit[j]<profit[j+1])
				{
					tp=profit[j];profit[j]=profit[j+1];profit[j+1]=tp;
					tp=deadline[j];deadline[j]=deadline[j+1];deadline[j+1]=tp;
				}
			}
		}

		int max=deadline[0];
		for( int i=1; i<n; i++)
			if(deadline[i]>max)
				max=deadline[i];
		System.out.println("Maximim deadline:"+max);
		
		int ans [] =new int[max];
		for(int i=0;i<max;i++)
			ans [i]=0;
		
		for(int i=0;i<n&&checkfull(ans);i++)	//jobs
		{
			for(int j=deadline[i]-1;j>=0;j--)	//traversing back according to deadline
			{
				if(ans[j]==0&&deadline[i]>j)
				{
					ans[j]=profit[i];
					break;
				}
			}
		}
		
		
		
		for( int i=0; i<max;i++)
			mincost+=ans[i];
		System.out.println("Maxmimum Profit :"+mincost);
	}
}