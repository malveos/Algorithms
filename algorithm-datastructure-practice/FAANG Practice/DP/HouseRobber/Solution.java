/******

@Author Omakr Malve


198. House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

***/
class Solution {
    public int rob(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] maal = new int[nums.length];
        maal[0] = nums[0];
        maal[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i< nums.length; i++) {
            maal[i] = Math.max(maal[i - 1], maal[i - 2] + nums[i]);
        }
        
        return maal[nums.length - 1];
    }
}