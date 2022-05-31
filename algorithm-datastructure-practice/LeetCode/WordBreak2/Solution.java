/***

@Author Omkar Malve
140. Word Break II

Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.


***/
class Solution {
    //private final Map<String, List<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
       return withDFS(s, wordDict);
    }

    private List<String> withDFS(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        dfs(ans, s, 0, wordDict, new StringBuilder());
        return ans;
    }

    private void dfs(List<String> ans, String s, int st, List<String> wd, StringBuilder cur) {
        if (s.length() == st) {
            ans.add(cur.toString().trim());
            return;
        }
        int l = cur.length();
        for (String w: wd) {
            if (s.startsWith(w, st)) {
                cur.append(" ").append(w);
                dfs(ans, s, st + w.length(), wd, cur);
                cur.delete(l, cur.length());
            }
        }
    }

    // private List<String> withDP(String s, List<String> wordDict) {
    //     if (cache.containsKey(s)) return cache.get(s);
    //     List<String> ans = new ArrayList<>();
    //     if (wordDict.contains(s)) ans.add(s);
    //     for (int i = 1; i < s.length(); i++) {
    //         String p1 = s.substring(0, i);
    //         String p2 = s.substring(i);
    //         if (wordDict.contains(p1)) {
    //             for (String part : wordBreak(p2, wordDict)) {
    //                 ans.add(p1 + " " + part);
    //             }
    //         }
    //     }
    //     cache.put(s, ans);
    //     return ans;
    // }
}