/***

@Author Omkar Malve

560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.


***/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        int curSum = 0;
        int ans = 0;

        for (int i = 0; i<n; i++) {
            curSum += nums[i];
            if (countMap.containsKey(curSum - k)) {
                ans += countMap.get(curSum - k);
            } 

            if (countMap.containsKey(curSum)) {
              countMap.put(curSum, countMap.get(curSum) + 1);  
            } else {
                countMap.put(curSum, 1);
            }
        }
        
        return ans;
    }
}