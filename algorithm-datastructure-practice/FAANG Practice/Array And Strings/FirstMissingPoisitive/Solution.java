/***
@Author Omkar Malve

41. First Missing Positive

Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

**/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // initialize negatives 0 to max
        for (int i = 0; i < n; i++)
            if (nums[i] <= 0 || nums[i] > n + 1) nums[i] = n + 2;
        
        for (int x : nums) {
            int i = x > 0 ? x - 1 : -x - 1;
            if (i >= 0 && i < n) {
                nums[i] = - Math.abs(nums[i]);
            }
        }

        for (int i = 0; i < n; i++)
            if (nums[i] > 0)
                return i + 1;
        
        return n + 1;
    }
}