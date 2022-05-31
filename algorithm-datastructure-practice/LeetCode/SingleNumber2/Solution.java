/***

@Author Omkar Malve

137. Single Number II

Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

***/
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int n :  nums) {
          ones = ~twos & (ones ^ n);
          twos = ~ones & (twos ^ n);
        }
        return ones;
    }
}