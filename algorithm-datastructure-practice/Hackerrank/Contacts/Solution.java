import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class TrieNode {
    private int count = 0;
    private Map<Character, TrieNode> children = new HashMap<>();
    
    public void putChildChar(char c) {
        children.putIfAbsent(c, new TrieNode());
    }
    
    public TrieNode getChild(char c) {
        return children.get(c);
    }

    public Integer getCount() {
        return count;
    }

    public void addCount() {
        count +=1;
    }

    public String toString(){
        return "[" + count + "], - " + children + "*";
    }
}

class Trie {
    TrieNode root = new TrieNode();
    
    public void addString(String s) {
        TrieNode tmp = root;
        for (char c: s.toCharArray()) {
            tmp.putChildChar(c);
            tmp = tmp.getChild(c);           
             tmp.addCount();
        }
    }
    
    public Integer getCount(String prefix) {
        TrieNode tmp = root;
        for (char c: prefix.toCharArray()) {
            tmp = tmp.getChild(c);
            if(null == tmp) {
                //System.out.println("Returning for char " + c + " of " + prefix);
                return 0;
            }
        }
        return tmp.getCount();
    }
    
    public String toString() {
        return root + "";
    }
}

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
                
        Trie trie = new Trie();        
        
        for (int i = 0; i < q; i++) {
            String query = scanner.next();
            String str = scanner.next();
            if ("add".equals(query)) {
                trie.addString(str);
            } else {
                System.out.println(trie.getCount(str));
            }
        }
        
    }
}
