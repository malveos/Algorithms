/**
@Author Omkar Malve

121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

**/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        
        int i = 0, res = 0, minPrice = Integer.MAX_VALUE;
        while (i < n) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            res = Math.max(res, prices[i] - minPrice);
            i++;
        }
        return res;        
    }
}