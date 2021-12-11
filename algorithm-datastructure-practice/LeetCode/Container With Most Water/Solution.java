/**

@Author Omkar Malve

Container With Most Water


***/

class Solution {
    public int maxArea(int[] height) {
        int leftI = 0;
        int rightI = height.length - 1;
        int maxArea = 0;
        while (leftI < rightI) {
            maxArea = Math.max(maxArea, 
                               Math.min(height[rightI], height[leftI]) * (rightI - leftI));
            if (height[leftI] > height[rightI]) {
                rightI -=1;
            } else {
                leftI +=1;
            }
        }
        
        return maxArea;
    }
