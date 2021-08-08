/***

@Author Omkar Malve

283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



***/
class Solution {
    public void moveZeroes(int[] nums) {
        int zidx = 0;
        for (int  i = 0; i<nums.length; i++) {
            if (nums[i] !=0) {
                int tmp = nums[i];
                nums[i] = nums[zidx];
                nums[zidx] = tmp;
                zidx++;
            }
        }
    }
}