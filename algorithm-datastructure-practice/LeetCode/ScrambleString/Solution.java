
/***

@Author Omkar Malve

87. Scramble String

We can scramble a string s to get a string t using the following algorithm:

If the length of the string is 1, stop.
If the length of the string is > 1, do the following:
Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
Apply step 1 recursively on each of the two substrings x and y.
Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.


*/
class Solution {
    static Map<String, Boolean> map=new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        return solve(s1, s2);
    }

    public boolean solve(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        String key = s1 + "|" + s2;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        boolean gotSwap = false;
        int len = s1.length();
        for (int i = 1; i < len; i++) {
            boolean withSwapping = solve(s1.substring(0, i), s2.substring(len - i, len)) && solve(s1.substring(i, len), s2.substring(0, len - i));
            boolean withNoSwapping = solve(s1.substring(0, i), s2.substring(0, i)) && solve(s1.substring(i, len), s2.substring(i, len));
            
            if (withSwapping || withNoSwapping) {
                gotSwap = true;
                break;
            }
        }
        
        map.put(s1 + "|" + s2, gotSwap);
        return gotSwap;
    }
    
}