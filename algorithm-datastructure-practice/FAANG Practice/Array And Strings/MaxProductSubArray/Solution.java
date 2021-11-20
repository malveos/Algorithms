/***

@Author Omkar Malve

152. Maximum Product Subarray

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.


***/
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE, maxNegative = 1, maxPositive = 1;
        boolean zeroFlag = false, positiveFlag = false, processed = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxNegative = maxPositive = 1;
                zeroFlag = true;
            } else if (nums[i] > 0) {
                positiveFlag = true;
                maxPositive *= nums[i];
                maxNegative = maxNegative != 1 ? maxNegative * nums[i] : maxNegative;
            } else { // if negative
                int temp = maxPositive;
                if (maxNegative * nums[i] == 1 )  {
                    processed = true;
                }
                maxPositive = Math.max(1, maxNegative * nums[i]);
                maxNegative  = temp * nums[i];
            }
            max = max < maxPositive ? maxPositive : max;
            System.out.println("mpos: " + maxPositive + "   mNeg: " + maxNegative + "  max: " + max);
        }
        if (max == 1) {
            if (positiveFlag) return max;
            if (zeroFlag && !processed) return 0;
        }
        return max;
    }
}