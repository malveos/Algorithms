/*****
Generate Parentheses



*****/
class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return null;
        List<String> paranList = new LinkedList<>();
        backTrack(paranList, "", 0, 0, n);
        return paranList;
    }
    
    public void backTrack(List<String> list, String cur_string, int open, int close, int max) {
        if (cur_string.length() == max * 2) {
            list.add(cur_string);
            return;
        }
        
        if (open < max) backTrack(list, cur_string + "(", open + 1, close, max);
        if (close < open) backTrack(list, cur_string + ")", open, close + 1, max);
    }
}