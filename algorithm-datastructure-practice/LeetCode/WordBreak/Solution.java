/**

@Author Omkar Malve

139. Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

***/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return getByDP(s, wordDict);
    }

    private boolean getByDP(String s, List<String> wd) {
        boolean []dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        Set<String> hs = new HashSet<>(wd);
        for (int i = s.length() - 1; i>= 0; i--) {
            for (int j = i + 1; !dp[i] && j <= s.length(); j++) {
                dp[i] = dp[j] & hs.contains(s.substring(i, j));
            }
        }
        return dp[0];
    }

    private boolean getByREcusrion(String s, List<String> wd) {
        return canBreak(0, s, wd);        
    }

    private boolean canBreak(int p, String s, List<String> wd) {
        if (p == s.length())
            return true;
        for (int i = p + 1; i<= s.length(); i++) {
            if(wd.contains(s.substring(p, i)) && canBreak(i, s, wd))
               return true;
        }
        return false;
    }
}