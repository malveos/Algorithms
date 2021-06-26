/***

@Author Omkar Malve


. Jump Game II


Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.
***/
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        
        int stairs = nums[0];
        int ladder = nums[0];// always try to have bigger ladder
        
        int jumps = 1;
        
        for (int i = 1; i < nums.length; i++) {
            //System.out.println("Stair : " + stairs + ", ladder: " + ladder);
            if (i == nums.length - 1)
                return jumps;
            
            stairs--;
            ladder--;
            
            // trying taking maximum ladder so that setps will be minimum
            if (nums[i] > ladder)
                ladder = nums[i];
            
            if (stairs == 0) {
                stairs = ladder;
                jumps++;
            }
        }
        return jumps;        
    }
}