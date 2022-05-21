/***

@Author Omkar Malve

131. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.



***/
class Solution {
    public List<List<String>> partition(String s) {
        return getByPalinCheckDFS(s);
    }

    private List<List<String>> getByPalinCheckDFS(String s) {
        List<List<String>> ans = new ArrayList<>();
        int len = s.length();
        if (s == null || len <= 0)
            return ans;

        dfsPalin(s.toCharArray(), 0, ans, new ArrayList<>(16));
        return ans;
    }

    private void dfsPalin(char [] c, int from, List<List<String>> ans, List<String> path) {
        if (from == c.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = from; i < c.length; i++) {
            if (checkPalin(c, from, i)) {
                path.add(new String(c, from, i - from + 1));
                dfsPalin(c, i + 1, ans, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean checkPalin(char[] c, int i, int j) {
        while(i <= j) {
            if (c[i] != c[j])
                return false;
            i++;j--;
        }
        return true;
    }

  /*  private List<List<String>> getByDPDFS(String s) {
        List<List<String>> ans = new ArrayList<>();
        int len = s.length();
        if (s == null || len <= 0)
            return ans;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]))// if prev and next are palindrome
                    dp[j][i] = true;
            }
        }
        dfs(s, new ArrayList<>(), 0, dp, ans);
        return ans;
    }

    private void dfs(String s, List<String> path, int st, boolean[][] dp, List<List<String>> ans) {
        if (st == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = st; i < s.length(); i++ ) {
            if (dp[st][i]) {
                path.add(s.substring(st, i + 1));
                dfs(s, path, i + 1, dp, ans);
                path.remove(path.size() - 1);
            }
        }
    }*/
}