/***

@Author Omkar Malve

746. Min Cost Climbing Stairs

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.


**/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length <= 1) return 0;

        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = cost[0];
        
        for (int i = 1; i < cost.length; i++) {
            dp[i + 1] = cost[i] + Math.min(dp[i], dp[i - 1]);
        }
        
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}