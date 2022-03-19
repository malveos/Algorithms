/***

@Author Omkar Malve

287. Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 
***/
class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] dt = new boolean[nums.length + 1];
         for (int n: nums)
             if (dt[n]) return n;
            else dt[n] = true;
        // Map<Integer, Boolean> map = new HashMap<>(nums.length);
        // for (int n: nums)
        //     if (map.containsKey(n)) return n;
        //     else map.put(n, true);
        
        
        // Set<Integer> data = new HashSet<>();
        // for (int n: nums)
        //     if (!data.add(n)) return n;
        return -1;
    }
}