/***

@ Author Omkar malve

1679. Max Number of K-Sum Pairs

You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.


***/
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int count = 0;
        while (l < r) {
            int s = nums[l] + nums[r];
            if (s ==  k) {
                count++;l++;r--;
            } else if (s > k) {
                r--;
            } else {
                l++;
            }
        }
        return count;
    }
/*
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer ct = mp.get(k - nums[i]);
            if (ct != null && ct > 0) {
                count++;
                mp.put(k - nums[i], mp.get(k - nums[i]) - 1);
            } else {
                mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }*/
}