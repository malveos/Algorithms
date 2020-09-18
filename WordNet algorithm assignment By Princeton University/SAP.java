import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
  This class find shortest anchestral path from two vertices.
  @author Omkar Malve
**/
public class SAP {

   private Digraph dg;
   private final HashMap<HashSet<Integer>, int[]> cache;
   
   // constructor takes a digraph (not necessarily a DAG)
   public SAP(Digraph G) {
	   if (G == null) {
		   throw new IllegalArgumentException();
	   }
	   dg = new Digraph(G);
	   cache = new HashMap<>();
   }

   // length of shortest ancestral path between v and w; -1 if no such path
   public int length(int v, int w) {
	   findSAP(v,w);
	   HashSet<Integer> key = new HashSet<>();
	   key.add(v);
	   key.add(w);
	   return cache.get(key)[0];
   }

   // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
   public int ancestor(int v, int w) {
	   findSAP(v,w);
	   HashSet<Integer> key = new HashSet<>();
	   key.add(v);
	   key.add(w);
	   return cache.get(key)[1];
   }

   private void findSAP(int v, int w) {
	   HashSet<Integer> key = new HashSet<>();
	   key.add(v);
	   key.add(w);
	   if (cache.containsKey(key)) {
		   return;
	   }
	   List<Integer> vl = new LinkedList<>();
	   vl.add(v);
	   List<Integer> wl = new LinkedList<>();
	   wl.add(w);
	   cache.put(key, findSAP(vl, wl));
   }

   private int[] findSAP(Iterable<Integer> v, Iterable<Integer> w) {
	   isValidVertices(v);
	   isValidVertices(w);
	   BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(dg, v);
	   BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(dg, w);

       int dist = Integer.MAX_VALUE;
	   int anchtr = -1;
       for (int ver = 0; ver < dg.V(); ver++) {
		   if (vPath.hasPathTo(ver) && vPath.distTo(ver) < dist 
		    && wPath.hasPathTo(ver) && wPath.distTo(ver) < dist) {
				int sm = vPath.distTo(ver) + wPath.distTo(ver);
				if (sm < dist) {
					dist = sm;
					anchtr = ver;
				}
			}
	   }
	   if (dist == Integer.MAX_VALUE) {
		   dist = -1;
	   }
	   return new int[] {dist, anchtr};
   }

   private void isValidVertices(Iterable<Integer> vl) {
	   if (vl == null)
		   throw new IllegalArgumentException();

	   Iterator it = vl.iterator();
	   if (!it.hasNext()) {
		   throw new IllegalArgumentException();
	   } 
      int ct = dg.V();
	  for (Integer v : vl) {
		  if (v == null || v.intValue() < 0 || v.intValue() >= ct) {
		    throw new IllegalArgumentException();
	      }
	  }	  
   }

   // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
   public int length(Iterable<Integer> v, Iterable<Integer> w) {
	   return findSAP(v, w)[0];
   }

   // a common ancestor that participates in shortest ancestral path; -1 if no such path
   public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
	   return findSAP(v, w)[1];
   }

   // do unit testing of this class
   public static void main(String[] args) {
	    In in = new In(args[0]);
		Digraph G = new Digraph(in);
		SAP sap = new SAP(G);
		while (!StdIn.isEmpty()) {
			int v = StdIn.readInt();
			int w = StdIn.readInt();
		 	int length   = sap.length(v, w);
			int ancestor = sap.ancestor(v, w);
			StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
		}
   }
}