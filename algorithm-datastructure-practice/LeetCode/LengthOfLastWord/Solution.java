/***

@Author Omkar Malve

Length of Last Word

Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.

***/
class Solution {
    public int lengthOfLastWord(String s) {
        if (s== null || s.strip().length() == 0) return 0;
        s = s.strip();

        int count = 0;
        int i = 0;
        for (i = s.length() - 1; i >= 0 ; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                break;
            } else {
                count++;
            }
        }
        return count;
    }
}