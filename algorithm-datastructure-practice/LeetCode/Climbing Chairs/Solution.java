/***

@Author Omkar Malve

 Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

***/

class Solution {
    public int climbStairs(int n) {
        return dp(n);
    }
    
    // recursion n^2
    public int climb(int n) {
        if(n <= 1) {
            return 1;
        }
        return climb(n - 1) + climb(n - 2);
    }
    
    // dynamic programming n
    public int dp(int n) {
        if(n <= 1) {
            return 1;
        }
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}