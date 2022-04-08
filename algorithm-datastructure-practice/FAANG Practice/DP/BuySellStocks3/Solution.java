/***

@Author Omkar Malve

123. Best Time to Buy and Sell Stock III

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).


***/
class Solution {
    public int maxProfit(int[] prices) {
        // find profit from left and pprofit from right and then find maximum left +right
        int n = prices.length;
        if(n == 0  || n == 1) return 0;
        
        
        int leftP[] = new int[n];
        int lowest = prices[0];
        for (int i = 1; i< n; i++) {
            // if transaction done or not done
            leftP[i] = Math.max(leftP[i - 1], prices[i] - lowest);
            lowest = Math.min(lowest, prices[i]);
        }

        int highest = 0;
        int rightTemp = 0;
        int ans = Integer.MIN_VALUE;        
        for (int i = n - 1; i >= 0; i--) {
            // if transaction done or not done
            rightTemp = Math.max(rightTemp, highest - prices[i]);
            highest = Math.max(highest, prices[i]);
            ans = Math.max(leftP[i] + rightTemp, ans);
        }

        return ans;
    }
}