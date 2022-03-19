/***

@Author Omkar Malve

1027. Longest Arithmetic Subsequence

Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.

Recall that a subsequence of an array nums is a list nums[i1], nums[i2], ..., nums[ik] with 0 <= i1 < i2 < ... < ik <= nums.length - 1, and that a sequence seq is arithmetic if seq[i+1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).

***/
class Solution {
    public int longestArithSeqLength(int[] nums) {
        // Logic while going forward we get if prev all has the same dii map then update lentgh in curr Map
        // Map of strt to [ map of diff to size]
        Map<Integer, Map<Integer, Integer>> mp = new HashMap<>();
        int ans = 1, n = nums.length;
        
        Map<Integer, Integer> tmp = new HashMap<>();
        tmp.put(nums[0], 1);
        mp.put(0, tmp);
    
        for (int i = 1; i < n; i++) {
            Map<Integer, Integer> curMap = new HashMap<>();
            for (int j = 0; j  < i; j++) {
                int d = nums[j] - nums[i];
                curMap.put(d, 2);
                
                // Next from j is there
                Map<Integer, Integer> existingDiffMap = mp.get(j);
                if (existingDiffMap.containsKey(d)) {
                    int l = existingDiffMap.get(d);
                    
                    // update new map
                    curMap.put(d, l + 1);
                }
                
                ans = Math.max(ans, curMap.get(d));
            }
            
            mp.put(i, curMap);
        }
        //System.out.println(mp);
        return ans;
    }
}