/**

@Author Omkar Malve

189. Rotate Array

Given an array, rotate the array to the right by k steps, where k is non-negative.

***/
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        k = k%n;
        //if (k == 0) return;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);        
    }

    private void reverse(int[] nums, int st, int ed) {
        while(st < ed) {
            int t = nums[st];
            nums[st] = nums[ed];
            nums[ed] = t;
            st++;ed--;
        }
    }
}