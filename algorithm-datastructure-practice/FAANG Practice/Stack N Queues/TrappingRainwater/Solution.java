/**
@Author Omkar Malve

42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

***/
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = 0;
        rightMax[n - 1] = 0;

        for (int i = 1 ; i < n; i++) {
            leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
        }
       
        for (int i = n - 2 ; i >= 0; i--) {
            rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int trappable = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(trappable > 0) ans += trappable;
        }
        return ans;
    }
}