/***

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

@author - omkar malve
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // <compliment, numIndex>
        int[] ans = new int[2];
        Map<Integer, Integer> sumComp = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            if (null == sumComp.get(target - nums[i])) {
                sumComp.put(nums[i], i);
            } else {
                //Needed index will be as sumComp.get(nums[i] - target) and 
                ans[0] = sumComp.get(target - nums[i]);
                ans[1] = i;                
            }
        }
        return ans;
    }
}