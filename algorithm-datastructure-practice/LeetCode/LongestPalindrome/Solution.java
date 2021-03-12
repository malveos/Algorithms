/*
Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.

*/


class Solution {
    public String longestPalindrome(String s) {
        if (null == s || s.length() < 1) return "";
        
        int st = 0, ed = 0;
        for (int i  = 0; i< s.length(); i++) {
            int len = centerExpand(s, i, i);
            int len2 = centerExpand(s, i, i + 1);
            len = Math.max(len, len2);
            
            // up we got greater length substring
            if (len > ed - st) {
                st = i - (len - 1)/2;
                ed = i + (len)/2;
            }
        }
        
        return s.substring(st, ed + 1);
      }
    
     private int centerExpand(String s, int left, int right) {
         while (left >=0 && right < s.length() && s.charAt(left)== s.charAt(right)) {
             left--;
             right++;
         }
         return right - left - 1;
     }
}