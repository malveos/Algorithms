/***

@Author Omkar Malve

115. Distinct Subsequences

Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
***/
class Solution {
    public int numDistinct(String s, String t) {
        // can solve using DP
        
        int sz = s.length();
        int tz = t.length();

        // Rows for main string
        int[][] dp = new int[tz + 1][sz + 1];
        for (int i = 0; i <= sz; i++) {
            dp[0][i] = 1;// All are subs of empty string
        }

        for (int i = 0; i < tz; i++) {
            for (int j = 0; j < sz; j++) {
                if (t.charAt(i) == s.charAt(j)) {// if same char then prev till letter + prev letter and prev target
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j];
                } else { // carry forward prev
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[tz][sz];
    }
}