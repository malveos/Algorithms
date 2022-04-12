/***

@Author Omkar Malve

647. Palindromic Substrings

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

***/
class Solution {
    public int countSubstrings(String s) {
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        // will fill upper tringle to check for all palindromes
        int count = 0;// all singles
        
        // fill digonal
        for (int i = 0; i < l; i++) {
            dp[i][i] = true;
            //count++;
        }
        
        // fill next from digonal cross
        for (int i = 0; i < l - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = true;
                //count++;
            } else
                dp[i][i+1] = false;
        }

        // fill remaining starting from 3rd col
        for (int d = 2; d < l; d++) {
            int i = 0, j = d;
            while (j < l) {
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    //count++;
                } else {
                    dp[i][j] = false;
                }
                i++;j++;
            }
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j< l; j++)
                if (dp[i][j]) count++;
        }
        return count;
    }
}