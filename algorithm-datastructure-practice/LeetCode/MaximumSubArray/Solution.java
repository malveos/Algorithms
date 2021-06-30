/***

@Author Omkar Malve

Maximum Subarray


Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
**/
class Solution {
    public int maxSubArray(int[] nums) {
       int sum = 0;
        int maxSum = nums[0];
       for (int i = 0; i < nums.length; i++) {
           sum += nums[i];
           maxSum = Math.max(sum, maxSum);
           
           // max will be zero if element is negative
           if (sum < 0)
               sum = 0;
       }
        return maxSum;
    }
}