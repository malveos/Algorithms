/*****

@author Omkar Malve

518. Coin Change 2

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.


*/

class Solution {
    public int change(int amount, int[] coins) {
       // int n = coins.length;
        
        int singledp[] = new int[amount + 1];
        singledp[0] = 1;
        for (int c : coins) {
            for (int num = c; num <= amount; num ++) 
                singledp[num] +=singledp[num - c];
        }
        return singledp[amount];
/*
        int dp[][] = new int[n + 1][ amount + 1]; // extra for 0 for start
        
        for (int i = 0; i <= n; i++ ) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + // with less amount to current addition
                        ( j < coins[i  - 1] ? 0  : dp[i][j - coins[i - 1]]); // without that prev coin
                }
            }
        }
        return dp[n][amount];*/
    }
}