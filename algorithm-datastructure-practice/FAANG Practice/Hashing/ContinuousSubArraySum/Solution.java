/***

@Author Omkar Malve

523. Continuous Subarray Sum

Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.

An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

****/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 0) return false;

        int sum = 0;
        // map of sum%k and index
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1); //Handling of zero

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum = sum % k;

            if (mp.containsKey(sum)) {
                int idx = mp.get(sum);
                if (i - idx > 1)
                    return true;
            } else
                mp.put(sum, i);
        }
        return false;
    }
}