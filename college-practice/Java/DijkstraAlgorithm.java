import java.util.*;
import java.io.*;

class DijkstraAlgorithm
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter total vertices:");
        int n=sc.nextInt();
        int matrix[][]= new int[n][n];
        int visited[]=new int[n];
        int preD[]=new int[n];
        int distance[]=new int[n];

        int min=0,nextNode=0;
        System.out.println("Enter adjecency matrix:");
        for(int i=0;i<n;i++)
        {
            visited[i]=0;
			preD[i]=0;         
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.nextInt();
                if(matrix[i][j]==0)
                {
                    matrix[i][j]=10000;
                }
            }
        }
        distance=matrix[0];
		distance[0]=0;
		visited[0]=1;
		
		for(int i=0;i<n;i++)
		{
			min=10000;
			for(int j=0;j<n;j++)
			{
				if(min>distance[j]&&visited[j]!=1)
				{
					min=distance[j];
					nextNode=j;
				}
			}
			
			visited[nextNode]=1;
			
			for(int c=0;c<n;c++)
			{
				if(visited[c]!=1)
				{
					if(min+matrix[nextNode][c]<distance[c])
					{
						distance[c]=min+matrix[nextNode][c];
						preD[c]=nextNode;
					}
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			int j;
			System.out.print("Path"+(i+1));
			j=i;
			do
			{
				j=preD[j];								// imp   j 
				System.out.println("<-"+(j+1));
			}while(j!=0);
			System.out.println("Distance:"+distance[i]);		// imp i
		}
	}
}