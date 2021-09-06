/***

@Author Omakr Malve

97. Interleaving String

Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.


***/
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int p1 = s1.length();
        int p2 = s2.length();
        int p3 = s3.length();
        if (p1 + p2 != p3) return false;
        Boolean [][] dp = new Boolean[p1 + 1][p2 + 1];
        return filldp(s1, s2, s3, 0, 0, dp);
    }
    
    private boolean filldp(String s1, String s2, String s3, int p1, int p2, Boolean [][]dp) {
        if (dp[p1][p2] != null) return dp[p1][p2];
        int p3 = p1 + p2;
        if (p3 == s3.length()) return true;
        
        // if char from s1 matches
        if ( p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3)) {
            dp[p1][p2] = filldp(s1, s2, s3, p1 + 1, p2, dp);
            if (dp[p1][p2]) return true;
        }
        
        // if char from s2 matches
        if ( p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3)) {
            dp[p1][p2] =  filldp(s1, s2, s3, p1, p2 + 1, dp);
            if (dp[p1][p2]) return true;
        }
        dp[p1][p2] = false;
        return false;
    }
}

     
   