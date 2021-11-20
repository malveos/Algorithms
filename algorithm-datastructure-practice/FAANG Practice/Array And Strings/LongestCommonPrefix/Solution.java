/***

@Author Omkar Malve

14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



***/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        String pref = strs[0];
        for (int i = 1; i< strs.length; i++) {
            String newPref = "";
            for (int j = 0; j< Math.min(pref.length(), strs[i].length()); j++) {
                if (pref.charAt(j) == strs[i].charAt(j))
                    newPref += pref.charAt(j);
                else
                    break;
            }
            pref = newPref;
            if (pref.isEmpty()) return "";
        }        
        return pref;
    }
}