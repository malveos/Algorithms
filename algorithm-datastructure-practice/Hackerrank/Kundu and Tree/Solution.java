import java.io.*;
import java.util.*;

class DisjointSet {

    DisjointSet parent = this;
    int size = 1;

    DisjointSet findRoot() { 
        if (this != parent) 
            parent = parent.findRoot();
        return parent;
    }

    void union(DisjointSet otherSet) {
        if (otherSet == this) return;
        DisjointSet myRoot = findRoot();
        DisjointSet otherRoot = otherSet.findRoot();
        if (myRoot == otherRoot) return;

        if (myRoot.size >= otherRoot.size) {
            otherRoot.parent = myRoot;
            myRoot.size += otherRoot.size;
        } else {
            myRoot.parent = otherRoot;
            otherRoot.size += myRoot.size;
        }
    }    
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DisjointSet[] components = new DisjointSet[N + 1];

        for (int i =0; i< N-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            char color = sc.next().charAt(0);

            if (color == 'r') continue; // we will be collectiong only blue colored eddges
            if (null == components[a])
                components[a] = new DisjointSet();
            if (null == components[b])
                components[b] = new DisjointSet();
            components[a].union(components[b]);
        }
        Set<DisjointSet> uniqRoots = new HashSet<>();
        for (int i = 0; i < N; i++)
            if (components[i] != null)
                uniqRoots.add(components[i].findRoot());
        
        long validTriplets = choose3from(N);
        for (DisjointSet comp: uniqRoots) {
            validTriplets -= choose3from(comp.size);
            validTriplets -= choose2from(comp.size) * (N - comp.size);
        }

        System.out.println(validTriplets % 1_000_000_007);
    }

    static long choose3from(int n) {
        return n * (n - 1) * (n - 2) / 6;
    }

    static long choose2from(int n) {
        return n * (n - 1) / 2;
    }

}