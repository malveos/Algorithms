/**

@Author Omkar Malve

188. Best Time to Buy and Sell Stock IV

You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

***/
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        
        if (k >= n/2) {
            int pf = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    pf += prices[i] - prices[i - 1];
                }
            }
            return pf;
        }

        // kth transaction till n prices.
        int [][]dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            // prepare previous profit here; Prevouos transaction sell - buy price
            int localMaxProfit = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                // if previous was greater or can do this transaction
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + localMaxProfit);
                // check if transaction got new Maximum
                localMaxProfit = Math.max(localMaxProfit, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
}