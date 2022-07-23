/***

@Author Omkar Malve

376. Wiggle Subsequence

A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.

For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between positive and negative.
In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. The first is not because its first two differences are positive, and the second is not because its last difference is zero.
A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.

Given an integer array nums, return the length of the longest wiggle subsequence of nums.


***/
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int []dpUp = new int[n];
        int []dpDown = new int[n];
        dpUp[0] = dpDown[0] = 1;


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums [i - 1]) {
                dpUp[i] = dpUp[i - 1];
                dpDown[i] = dpDown[i - 1];
            } else if (nums[i] < nums [i - 1]) { //moving up then take from down
                dpUp[i] = dpDown[i - 1] + 1;
                dpDown[i] = dpDown[i - 1];
            } else { // moving down so take from up
                dpUp[i] = dpUp[i - 1];
                dpDown[i] = dpUp[i - 1] + 1;
            }
        }
        return Math.max(dpUp[n - 1], dpDown[n - 1]);
    }
}