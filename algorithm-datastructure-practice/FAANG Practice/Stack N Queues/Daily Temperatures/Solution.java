/***

@Author Omkar Malve

739. Daily Temperatures

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

***/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Using a stack to store decreasing temperature
        Stack<Integer> st = new Stack<>();
        int len = temperatures.length;
        int[] ans = new int[len];
        st.push(0);
        for (int i = 1; i < len; i++) {
            if (temperatures[st.peek()] < temperatures[i]) {  // cur is greater then set all lesser temp this index.
           
                while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                    int id = st.pop();
                    ans[id] = i - id;
                }
            }
            st.push(i);
        }

        return ans;
        
    }
}