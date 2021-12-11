/****

@Author Omkar Malve

Longest Common Prefix


****/


class Solution {
    public String longestCommonPrefix(String[] strs) {
    if (strs.length ==0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
        // Check if next string has prefix like previous
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    }
    return prefix;
    }
}