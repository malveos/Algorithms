/**
Minimum Number of Removals to Make Mountain Array

Bitonic subsequence

**/

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int len = nums.length;
        int[] right = new int[len];
        int[] left  = new int[len];
        
        right[0] = left[0] = 1;
        for (int i = 0; i<len; i++) {
            int max = 1;
            for(int j = 0; j<i; j++) {
                if (nums[i]> nums[j]) {
                    max = Math.max(max, left[j] + 1);
                }
            }
            left[i] = max;
        }
        
        for (int i = len - 1; i>=0; i--) {
            int max = 1;
            for(int j = i + 1; j<len; j++) {
                if (nums[i]> nums[j]) {
                    max = Math.max(max, right[j] + 1);
                }
            }
            right[i] = max;
        }
        
        // Finding logest biotonic subsequece
        int max = 0;
        for (int i = 0; i<len; i++) {
            if (left[i]>1 && right[i]>1) {
                max = Math.max(max, left[i] + right[i] - 1);
            }
        }
        return len - max;
    }
}