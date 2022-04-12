/****

@Author Omkar Malve

494. Target Sum

You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

***/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2002];
        for (int[] a : dp)
            Arrays.fill(a, Integer.MIN_VALUE);
        return findSumWays(nums, target, 0, 0, dp);
    }

    private int findSumWays(int [] nums, int target, int sum, int i, int[][] dp) {
        if (i == nums.length) {
            // at last we need sum required
            if (target == sum) {
                return 1;
            } else return 0;
        } else {
            // Recursive
            if (dp[i][sum + 1000] != Integer.MIN_VALUE)
                return dp[i][sum + 1000];
            int add = findSumWays(nums, target, sum + nums[i], i + 1, dp);
            int subs = findSumWays(nums, target, sum - nums[i], i + 1, dp);
            return dp[i][sum + 1000] = add + subs;
        }
    }
}