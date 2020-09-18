import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 This function uses Wordnet to outcast that is at maximum distance from other points
 @author Omkar Malve
**/
public class Outcast {
    
   private WordNet wn;

   public Outcast(WordNet wordnet)  {       // constructor takes a WordNet object
        this.wn =  wordnet;
   }
   
   public String outcast(String[] nouns) {  // given an array of WordNet nouns, return an outcast
       String outCast = nouns[0];
       int dist = findDist(nouns[0], nouns);
       for (int i = 1; i < nouns.length; i++) {
           int tempD = findDist(nouns[i], nouns);
           if (tempD > dist) {
               dist = tempD;
               outCast = nouns[i];
           }
       }
       return outCast;
   }
   
   private int findDist(String st, String[] nuns) {
       int d = 0;
       for (String s : nuns) {
           d+= wn.distance(s, st);
       }
       return d;
   }

   public static void main(String[] args) { // see test client below
      WordNet wordnet = new WordNet(args[0], args[1]);
      Outcast outcast = new Outcast(wordnet);
      for (int t = 2; t < args.length; t++) {
        In in = new In(args[t]);
        String[] nouns = in.readAllStrings();
        StdOut.println(args[t] + ": " + outcast.outcast(nouns));
      }
   }
   
}