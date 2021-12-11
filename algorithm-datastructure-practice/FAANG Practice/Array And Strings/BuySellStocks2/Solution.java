/***
@Author Omkar Malve

122. Best Time to Buy and Sell Stock II

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

***/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        
        int i = 0, res = 0, minima = prices[0], maxima = prices[0];
        while (i < n - 1) {
            while (i < n-1 && prices[i] >= prices[i+1])
                i++;
            minima = prices[i];
            while (i < n-1 && prices[i] <= prices[i+1])
                i++;
            maxima = prices[i];
            res += maxima - minima;
        }
        return res;
    }
}