/**

@Author Omkar Malve

792. Number of Matching Subsequences

Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".

**/
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        //Create Buckets for all words and access them per chars in the String
        int ans = 0;
        List<StringBuilder>[] buckets = new ArrayList[128];
        for (int c = 0; c <= 'z'; c++)
            buckets[c] = new ArrayList<>();
        for (String w : words) {
            buckets[w.charAt(0)].add(new StringBuilder(w));
        }

        for (char c: s.toCharArray()) {
            List<StringBuilder> matched = buckets[c];
            buckets[c] = new ArrayList<>();//Made to occupy from second.
            
            if(matched != null) {
                for (StringBuilder sb : matched) {
                    sb.deleteCharAt(0); //marking visited
                    if (sb.length() == 0) {// all found in the String
                        ans++;
                    } else {
                        buckets[sb.charAt(0)].add(sb);
                    }
                }    
            }  
        }
        return ans;
    }
}