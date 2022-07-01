/***

@Author Omkar Malve

151. Reverse Words in a String

Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

***/
class Solution {
    public String reverseWords(String str) {
        String[] tokens = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : tokens) {
            if (!s.trim().equals("")) {
                sb.insert(0, s);
                sb.insert(0, " ");
            }
        }
        return sb.toString().trim();
    }
}