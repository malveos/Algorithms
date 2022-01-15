/***
@Author Omkar Malve


22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

***/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        generate(ans, "", 0, 0 ,n);
        return ans;
    }

    private void generate(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == 2 * max) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            generate(ans, new StringBuilder(cur).append("(").toString(), open + 1, close, max);
        }
        if (open > close) {
            generate(ans, new StringBuilder(cur).append(")").toString(), open, close + 1, max);
        }
        
    }
}