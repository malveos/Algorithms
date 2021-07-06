/**
@Author Omkar Malve

Jump Game

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
**/
class Solution {
    public boolean canJump(int[] nums) {
        
        int st = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > st)
                return false;
            st = Math.max(st, i + nums[i]);
        }
        return (st >= nums.length - 1);
    }
}