/****
16. 3Sum Closest

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.



***/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <3) 
            return 0;
        int diff = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target)
                    low++;
                else
                    high--;
            }
            if (diff == 0)
                break;
        }
        return target - diff;
    }
}