/***

@Auhtor Omkar Malve

462. Minimum Moves to Equal Array Elements II

Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
In one move, you can increment or decrement an element of the array by 1.
Test cases are designed so that the answer will fit in a 32-bit integer.

***/
class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int moves = 0;
        if (n % 2 == 0) {
            int m1 = n / 2;
            int m2 = n / 2 - 1;
            int ans1 = 0, ans2 = 0;
            //System.out.println("Mid are :" + nums[m1] + ", " + nums[m2]);
            for (int i = 0; i < n; i++) {
                ans1 += Math.abs(nums[m1] - nums[i]);
                //ans2 += Math.abs(nums[m2] - nums[i]);
            }
            moves = Math.min(ans1, ans1);
        } else {
            int m = n / 2;
            //System.out.println("Mid is :" + nums[m]);
            for (int i = 0; i < n; i++) {
                moves += Math.abs(nums[m] - nums[i]);
            }
        }
        return moves;
    }
}