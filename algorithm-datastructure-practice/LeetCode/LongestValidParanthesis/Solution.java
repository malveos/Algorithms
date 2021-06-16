/***
32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

**/
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int [] dp =  new int[n+1];
        dp[0] = 0;

        for (int i = 0; i<n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                dp[i+1] = 0;
            } else {
                if (stack.isEmpty()) {
                    dp[i+1] = 0;
                } else {
                    dp[i+1] = dp[i] + 2 + dp[stack.peek()];
                    stack.pop();
                }
            }
        }
        int max = 0;
        for (int i=0; i<=n; i++) {
            max= Math.max(max, dp[i]);
        }
        return max;
    }
}