/***

Regular Expression Matching



****/


class Solution {
    public boolean isMatch(String s, String p) {
        // Using recursion
        
        if (p.isEmpty()) return s.isEmpty();
        // Check first match to check if it is contune or .
        boolean continueMatch = (!s.isEmpty() && 
                                (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        
        //Recursing case
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // We can skip/consider current char due to *
            return (isMatch(s, p.substring(2)) ||
                    // Char is moving ahead
                   continueMatch && isMatch(s.substring(1), p));
            
        } else { //Continue after 1 character
            return continueMatch && isMatch(s.substring(1), p.substring(1));
        }
        
        
    }
}