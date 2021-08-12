/***

@Author Omkar MAlve

 Largest Rectangle in Histogram
 
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Comments inline.

***/
class Solution {
    public int largestRectangleArea(int[] h) {
        if  (h == null || h.length == 0) {
            return 0;
        }
        int i = 0, j = h.length;
        int maxA = 0;
        
        if (j == 1) return h[0];

        // inset in stack as growing height if smaller found find height using prev long.
        Stack<Integer> st = new Stack<>();
        while(i < j) {
            if(st.isEmpty() || h[st.peek()] <= h[i]) { // Insert while stack top is less than current
                st.push(i++);
            } else {                
                 // if stack has greater than new height
                int t = st.pop();
                // area will be prev low height * current width (prev index to cur index - 1)
                // i.e. prevLow next rect to rect of highest size rect
                maxA= Math.max(maxA, h[t] * (st.isEmpty() ? i : i - st.peek() - 1));
            }
        }
        while(!st.isEmpty()) {
            int t = st.pop();
            maxA= Math.max(maxA, h[t] * (st.isEmpty() ? i : i - st.peek() - 1));
        }
        return maxA;
    }
}