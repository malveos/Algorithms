/***

@Author Omkar Malve

905. Sort Array By Parity

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

**/
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int evenptr = 0;
        int oddptr = nums.length - 1;
        while (evenptr < oddptr) {
            if (nums[evenptr] %2 == 1) {
                if (nums[oddptr] %2 == 0) {
                    int t = nums[oddptr];
                    nums[oddptr] = nums[evenptr];
                    nums[evenptr] = t;
                    evenptr++;
                }
                oddptr--;
            } else
                evenptr++;
        }
        return nums;
    }
}