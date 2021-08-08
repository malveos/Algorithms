/***

@Author Omkar Malve

 Edit Distance
 
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character



**/


class Solution {
    public int minDistance(String word1, String word2) {
        // problme can be solved by dp like common subsequence
        int l1 = word1.length();
        int l2 = word2.length();
        if (l1 == 0) return l2;
        if (l2 == 0) return l1;
        int[][] dp = new int[l1 + 1][l2 + 1];
        
        // for (int i = 0; i <= l1; i++)
        //     dp[i][0] = i;
        // for (int i = 0; i <= l2; i++)
        //     dp[0][i] = i;
        
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i ==0 || j ==0){
                    if (i == 0)
                        dp[i][j] = j;
                    else
                        dp[i][j] = i;
                    continue;
                }
                int cost = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + cost, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
            }
        }
        return dp[l1][l2];
    }
}