/***

@Author Omkar Malve

581. Shortest Unsorted Continuous Subarray

Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.
****/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length - 1;
        int left = -1, right = -1;
        int max = nums[0], min = nums[len];

        for (int i = 1; i <= len; i++) {
            int leftCur = nums[i], rightCur = nums[len - i];
            if (max <= leftCur) {
                //System.out.println("Max ["+max+"] <= leftCur ["+leftCur +"]; updating max.");
                max = leftCur;                
            } else {
                //System.out.println("Setting right = " + i);
                right = i;  
            }
            if (min >= rightCur) {
                //System.out.println("Min ["+min+"] >= rightCur ["+ rightCur +"]; updating min.");
                min = rightCur;                
            } else {
                left = i;
                //System.out.println("Setting left " + i);
            }
        }
        //System.out.println("Left = " + left + " Right = " + right);
        return Math.max(0, left + right - len + 1);
    }
}