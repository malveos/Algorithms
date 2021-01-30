import java.io.*;
import java.util.*;

class TopologicalSort
{
	private int V;
	private LinkedList<Integer> adj[];
	
	TopologicalSort(int x)
	{
		V=x;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			adj[i]=new LinkedList();
		}
	}
	void addedge(int u,int v)
	{
		adj[u].add(v);
	}
	void topogo(int i,boolean visited[],Stack s)
	{
		visited[i]=true;
		Integer x;
		Iterator<Integer> it= adj[i].iterator();
		
		while(it.hasNext())
		{
			x=it.next();
			if(!visited[x])
				topogo(x,visited,s);
		}
		s.push(new Integer(i));
	}
	void topo()
	{
		Stack s=new Stack();
		boolean visited[]=new boolean[V];
		Arrays.fill(visited,false);
		
		for(int i=0;i<V;i++)
			if(visited[i]==false)
				topogo(i,visited,s);
			
		while(s.empty()==false)
				System.out.print((s.pop()+1)+" ");
	}
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of vertices");
        int n=sc.nextInt();
        TopologicalSort g1 = new TopologicalSort(n);
        int x,y,p;
        System.out.println("Enter no of edges");
        p=sc.nextInt();
        for (int i=0;i<p ;i++ ) 
        {
            System.out.println("enter two vertices forming edges");
            x=sc.nextInt();
            y=sc.nextInt();
            g1.addedge(x-1,y-1);    
        }
        System.out.println("Following is a Topological " +
                           "sort of the given topologicalSort");
        g1.topo();
		
	}
}