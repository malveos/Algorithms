import java.io.*;
import java.util.*;

class DisJointSet {
    int parent[];
    int count[];

    public DisJointSet(int s) {
        parent = new int[s+1];
        count = new int[s+1];
        for (int i=0; i<s; i++) {
            parent[i] = i;
            count[i] = 1;
        }
    }

    public void union(int left, int right) {
        int rl = find(left);
        int rr = find(right);
        if (rl == rr) return;

        if (count[rl] < count[rr]) {
            parent[rl] = rr;
            count[rr] += count[rl];
        } else {
            parent[rr] = rl;
            count[rl] +=count[rr];
        }
    }

    public int find(int node) {
        int root = node;
        while (root!=parent[root])
            root = parent[root];
        return root;
    }

    public int size(int node) {
        int parent = find(node);
        return count[parent];        
    }

    public boolean isConnected(int left, int right) {
        return (find(left) == find(right));
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        DisJointSet ds = new DisJointSet(N);
        while(Q>0) {
            String query = sc.next();
            //System.out.print(query);
            if (query.equals("M")) {
                int left = sc.nextInt();
                int right = sc.nextInt();
                ds.union(left, right);
            } else {
                int node = sc.nextInt();
                System.out.println(ds.size(node));
            }
            Q--;
        }
    }
}