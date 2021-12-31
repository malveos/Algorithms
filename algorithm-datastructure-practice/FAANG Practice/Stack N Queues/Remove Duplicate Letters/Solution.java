/***

@Author Omkar Malve


316. Remove Duplicate Letters
Medium

Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.


***/

class Solution {
    public String removeDuplicateLetters(String s) {
        int [] ct = new int[26];
        for (char c : s.toCharArray())
            ct[c - 'a']++;
        
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            ct[c -  'a' ]--;
            if (st.contains(c)) continue;
            
            // pop as it will occure again
            while (!st.isEmpty() && st.peek() > c && ct[st.peek() - 'a'] > 0)
                st.pop();
            st.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }
}