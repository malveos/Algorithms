import java.io.*;
import java.util.*;

class PrimsAlgorithm
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter total vertices:");
        int n=sc.nextInt();
        int matrix[][]= new int[n][n];
        int visited[]=new int[n];
        System.out.println("Enter adjecency matrix:");
        int min=0,u=0,v=0,total=0;
		int MAX=9999;
		Arrays.fill(visited,0);
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				matrix[i][j]=sc.nextInt();
				if(matrix[i][j]==0)
					matrix[i][j]=MAX;
			}
			
		visited[0]=1;

		for(int c=0;c<n-1;c++)     //n-1 means 1 source other are destination
		{
			min=MAX;
			for(int i=0;i<n;i++)
			{
				if(visited[i]==1)
				{
					for(int j=0;j<n;j++)
					{
						if(visited[j]!=1)
						{
								if(min>matrix[i][j])
								{	
									min=matrix[i][j];
									u=i;v=j;
								}
						}
					}
				}
			}
			
			visited[v]=1;
			total+=min;
			System.out.println("Edge:"+(u+1)+"->"+(v+1)+"="+min);
		}
	System.out.println("MINIMUM Spanning tree weight:"+total);
	}
	
}