import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
 
    class Trie {
        private TrieNode root = new TrieNode(' ');
        class TrieNode {
            char c;
            TrieNode children[];
            boolean isEnd;

            TrieNode(char c) {
                this.c = c;
                this.children = new TrieNode[10];
                this.isEnd = false;
            }

            public String toString() {
                return "<[children - " + children + "], isEnd :- " + isEnd +">";
            }
        }
        
        private int getIndex(char c) {
            return c - 'a';            
        }

        public String addString(String s) {
            TrieNode node = root;
            int len = s.length();
            String result = null;

            for(int i=0; i<len; i++) {
                char c = s.charAt(i);
                if(node.children[getIndex(c)] != null 
                    && node.children[getIndex(c)].isEnd)
                    result = s;
                if(node.children[getIndex(c)] == null)
                    node.children[getIndex(c)] = new TrieNode(c);
                node = node.children[getIndex(c)];

                if(i == len-1) { // Last Iteration
                    node.isEnd = true;
                    for(int x = 0; x < 10; x++)
                        if(node.children[x] != null && result == null)
                            result = s;
                }
            }           
            return result;
        }
        public String toString() {
            return "Trie{" + root + "}";
        }  
    }

class Result {

    public static void noPrefix(List<String> words) {
        Trie t = new Trie();
        boolean bad = false;
        for (String word: words) {
            String out = t.addString(word);
            if (null != out) {
                System.out.println("BAD SET");
                System.out.println(out);
                bad = true;
                //System.out.println(t);
                break;
            }
        }
        if (!bad) {
            System.out.println("GOOD SET");
            //System.out.println(t);
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        Result.noPrefix(words);

        bufferedReader.close();
    }
}
