/***
@Author Omkar Malve


219. Contains Duplicate II

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.


***/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // num, index
        Map<Integer, Integer> mp = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer c =  mp.put(nums[i], i);
            if(c != null) {
                if (i - c <= k) return true;
            }           
        }
        return false;
    }
}