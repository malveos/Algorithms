
/***
@Author Omkar Malve

75. Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.


***/
class Solution {
    public void sortColors(int[] nums) {
     
        int l = 0, r = nums.length - 1;
        int c = 0;
        while (c<=r) {
            if (nums[c] == 0) {
                swap(nums, c, l);
                c++;
                l++;
            } else if (nums[c] == 2) {
                swap(nums, c, r);
                r--;
            } else {
                c++;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
    }
}