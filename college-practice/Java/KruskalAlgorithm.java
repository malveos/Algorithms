import java.io.*;
import java.util.*;

class KruskalAlgorithm
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter total vertices:");
        int n=sc.nextInt();
        int matrix[][]= new int[n][n];
        int parent[]=new int[n];
        System.out.println("Enter adjecency matrix:");
        int min=0,u=0,v=0;
		int noofedges=1,total=0;

		Arrays.fill(parent,0);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.nextInt();
                if(matrix[i][j]==0)
                {
                    matrix[i][j]=9999;
                }
            }
        }
	
		while(noofedges<n)
		{
			min=9999;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(matrix[i][j]<min)
					{
						min=matrix[i][j];
						u=i;v=j;
					}
				}
			}
			
			while(parent[u]!=0)
				u=parent[u];
			while(parent[v]!=0)
				v=parent[v];
			
			if(u!=v)
			{
				noofedges++;
				
				System.out.println("Edge:"+(u+1)+"->"+(v+1)+"="+min);
				parent[v]=u;total+=min;
			}
			matrix[u][v]=matrix[v][u]=9999;							//very important step
		}
		System.out.println("MIn weight:"+total);
	}
}