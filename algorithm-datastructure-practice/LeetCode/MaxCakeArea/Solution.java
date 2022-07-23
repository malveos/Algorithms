/**

@Auhtor Omkar Malve

1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts

You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a large number, return this modulo 109 + 7.


***/
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        // maximize heightCut and widthCut and return amax ans
        int maxH = horizontalCuts[0];
        int maxV = verticalCuts[0];
              
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
        
        for (int i = 1; i < verticalCuts.length; i++) {
            maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length - 1]);
        
        //System.out.println("MaxH :" + maxH  + ", MaxV:" + maxV);
        long ans = 1l*maxH*maxV;
        return (int)(ans%1000000007);
    }
}