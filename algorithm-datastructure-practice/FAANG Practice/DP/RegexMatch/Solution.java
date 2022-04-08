/***

@Author Omakr Malve

10. Regular Expression Matching

Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

***/
class Solution {
    // Using a DP solution
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        if (pl == 0) return sl == 0 ? true : false;
        
        
        boolean[][] dp = new boolean[sl + 1][pl + 1]; // Extra for starting empty string
        dp[0][0] = true;

        //fill horizonatal
        for (int j = 2; j <= pl; j++)
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        
        for (int j = 1; j <= pl; j++) {
            for (int i = 1; i <= sl; i++) {
                // if same char or any char then get prev
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i- 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] // default for *
                        || ((s.charAt(i - 1) == p.charAt(j - 2) // * as empty string
                            || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                }
            }
        }
        return dp[sl][pl];
    }
}