import java.util.HashMap;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;

/**
 This class finds distnace between two nouns in wordnet(as nodes in graph)
 @author Omkar Malve
**/
public class WordNet {

   private Digraph digfh;
   private final HashMap<String, Bag<Integer>> synonymsMap;
   private final HashMap<Integer, String> synMap;
   private final SAP sap;

   // constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms) {
	   if (null == synsets || null == hypernyms)
		   throw new IllegalArgumentException();
	   synonymsMap = new HashMap<>();
	   synMap = new HashMap<>();
	   int count = readSynSets(synsets);
	   
	   digfh = new Digraph(count);
	   readHypernyms(hypernyms);
	   
	   DirectedCycle dc = new DirectedCycle(digfh);
	   if (dc.hasCycle())
		   throw new IllegalArgumentException();
	   sap = new SAP(digfh);

       int rc = 0;
	   for (int i = 0; i < digfh.V(); i++) {
		   if (digfh.outdegree(i) == 0)
			   rc++;
	   }
	   if (rc != 1)
		   throw new IllegalArgumentException();
   }

   private int readSynSets(String synSets) {
	   In in = new In(synSets);
	   int ct = 0;
	   while (in.hasNextLine()) {
		   ct++;
		   // id, nouns
		   String line = in.readLine();
		   String []claues = line.split(",");
		   int id = Integer.parseInt(claues[0]);
		   synMap.put(id, claues[1]);
		   
		   String []nouns = claues[1].split(" ");
		   for (String n : nouns) {
			   Bag<Integer> bagN = synonymsMap.get(n);
			   if (bagN == null) {
				   bagN = new Bag<>();
				   synonymsMap.put(n, bagN);
			   }
			   bagN.add(id);
		   }
	   }	   
	   return ct;
   }

   private void readHypernyms(String hypernyms) {
	   In in = new In(hypernyms);
	   while (in.hasNextLine()) {
		   String line = in.readLine();
		   String []edges = line.split(",");
		   int v = Integer.parseInt(edges[0]);
		   for (int i = 1; i < edges.length; i++) {
			   int w = Integer.parseInt(edges[i]);
			   digfh.addEdge(v, w);
		   }
	   }
   }
   
   // returns all WordNet nouns
   public Iterable<String> nouns() {
	   return synonymsMap.keySet();
   }

   // is the word a WordNet noun?
   public boolean isNoun(String word) {
	   if (null == word)
		   throw new IllegalArgumentException();
	   return synonymsMap.containsKey(word);
   }

   // distance between nounA and nounB (defined below)
   public int distance(String nounA, String nounB) {
	   validate(nounA);
	   validate(nounB);
	   
	   Bag<Integer> nA = synonymsMap.get(nounA);
	   Bag<Integer> nB = synonymsMap.get(nounB);
	   return sap.length(nA, nB);
   }

   // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
   // in a shortest ancestral path (defined below)
   public String sap(String nounA, String nounB) {
	   validate(nounA);
	   validate(nounB);

	   Bag<Integer> nA = synonymsMap.get(nounA);
	   Bag<Integer> nB = synonymsMap.get(nounB);
	   int anc = sap.ancestor(nA, nB);
	   
	   return synMap.get(anc);
   }

   private void validate(String noun) {
	   if (!synonymsMap.containsKey(noun))
		   throw new IllegalArgumentException();
   }
   
   // do unit testing of this class
   //public static void main(String[] args) {
//	   
  // }
}