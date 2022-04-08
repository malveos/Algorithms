/***

@Author Omkar Malve

32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

****/
class Solution {
    public int longestValidParentheses(String s) {
        int cur = 0, ans = 0;
        
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(cur);
                cur = 0;
            } else {
                if (st.isEmpty()) {
                    cur = 0;
                } else {
                    cur += 2 + st.pop();
                    ans = Math.max(ans, cur);
                }
            }
        }
        return ans;
    }
}