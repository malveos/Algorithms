/**

@Author Omkar Malve


Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

**/
class Solution {
    public boolean isMatch(String s, String p) {
        int strlen = s.length();
        int pattlen = p.length();
        int i = 0, j = 0;
        int lastStarPos = -1, lastMatchPos = 0;
        
        while (i < strlen) {
            // if char Match or ?  match
            if (j < pattlen && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < pattlen && (p.charAt(j) == '*')) {
                lastMatchPos = i;
                lastStarPos = j;
                j++;
            } else if (lastStarPos != -1) { // we are at end so check from previous start to check for match
                lastMatchPos++;
                i = lastMatchPos;
                j = lastStarPos + 1;
                
            } else return false;
        }
        while(j < pattlen && p.charAt(j) == '*') j++;
        
        return j == pattlen;
    }
}