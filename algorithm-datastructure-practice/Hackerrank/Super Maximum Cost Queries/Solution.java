import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static int findParent(int node, int[] parent) {
        while(parent[node] != node)
            node = parent[node];
        return node;
    }

    static class Edge implements Comparable<Edge>{
       int dot1;
       int dot2;
       int weight;
       
       public int compareTo(Edge other) {
           return Integer.signum(this.weight - other.weight);
       }
       
       public String toString() {
           return "["+dot1+","+dot2+" ("+weight+")]";
       }
    }

    static class WeightPaths implements Comparable<WeightPaths>{
        long weights = 0L;
        long paths = 0L;
        WeightPaths() {}
        WeightPaths(long wts, long pts) {
            weights = wts;
            paths = pts;
        }
        
        public int compareTo(WeightPaths other) {
           return Long.signum(this.weights - other.weights);
        }

        public boolean equals(Object obj) { 
               if(this == obj) 
                return true; 
            if(obj == null || obj.getClass()!= this.getClass()) 
                return false; 
            WeightPaths wp = (WeightPaths) obj; 
            return (wp.weights == this.weights && wp.paths == this.paths); 
        } 
        public int hashCode() {
                return (int)( 37L * weights + 47L * paths);
        }
        public String toString() {
            return "[weights:"+weights+", paths:"+paths+"]";
        }
    }

    static long search(List<WeightPaths> weightPaths, int n) {
        long result = 0;
        int min =0, max = weightPaths.size() - 1;
        while(true) {
            if (max-min <=1)
                break;
            int mean = (max + min)/2;
            if (weightPaths.get(mean).weights > n)
                max = mean;
            else
                min = mean;
        }
        if (weightPaths.get(max).weights <= n) {
            result = weightPaths.get(max).paths;
        } else {
            result = weightPaths.get(min).paths;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        List<Edge> edges = new ArrayList<>(n - 1);
        for (int i = 0;i < n - 1;i++) {
            Edge e = new Edge();
            e.dot1 = sc.nextInt();
            e.dot2 = sc.nextInt();
            e.weight = sc.nextInt();
            edges.add(e);
        }
        Collections.sort(edges);
        //System.out.println(edges);
        
        int [] root = new int[n + 1];
        int [] count = new int[n + 1];
        for (int i = 1;i < n + 1;i++) {
            root[i] = i;
            count[i] = 1;
        }
    
        List<WeightPaths> weightPaths = new LinkedList<>();  
        WeightPaths wp = new WeightPaths();
        weightPaths.add(new WeightPaths());
        int k = 0;
        while (k<n-1) {
            wp.weights = edges.get(k).weight;
            while (k<n - 1 && edges.get(k).weight == wp.weights)
            {
                int dot1 = edges.get(k).dot1;
                int dot2 = edges.get(k).dot2;
                int r1 = findParent(dot1, root);
                int r2 = findParent(dot2, root);
                if (r1 != r2) {
                    wp.paths += count[r2] * count[r1];
                    root[r2] = r1;   
                    count[r1] += count[r2];
                    count[r2] = 0;
                }
                k++;
            }
            //System.out.println(weightPaths);
            weightPaths.add(new WeightPaths(wp.weights, wp.paths));
        }
        //Collections.sort(weightPaths);
       // System.out.println(weightPaths);
        while (q > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            long ln = search(weightPaths, l-1);
            long rn = search(weightPaths, r);
            long p = rn - ln;
            System.out.println(p);
            q--;
        }
		sc.close();
    }

    static void print(int[] arr) {
        System.out.print("[");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println("]");
    }
}
                                                                                          
