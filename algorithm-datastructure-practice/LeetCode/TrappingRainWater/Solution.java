/**
 Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

***/
class Solution {
    public int trap(int[] height) {
        // go from both sides and do it one by one elevation
        
        int trap = 0;
        if(height == null || height.length == 0)
            return trap;
        
        int start = 0, end = height.length - 1;
        int maxL = height[start];
        int maxR = height[end];
        
        while(start < end) {
            // left is smaller; check one block of length from left
            if (height[start] < height[end]) {
                int checkingHeight = height[++start];

                // water wil trap if next is smaller than left
                if (checkingHeight < maxL) {
                    trap += Math.min(maxL, maxR) - checkingHeight;
                } else { // update left
                    maxL = checkingHeight;
                }                
            } else { // right is smaller and check block from right
                int checkingHeight = height[--end];
                
                // water will trap if next is smaller than right
                if (checkingHeight < maxR) {
                    trap += Math.min(maxL, maxR) - checkingHeight;
                } else {
                    maxR = checkingHeight;
                }
            }
        }
        return trap;
    }
}