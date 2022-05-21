/***

@Author Omkar Malve

125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.


***/
class Solution {
    public boolean isPalindrome(String s) {
        // String str = parse(s);
        // return new StringBuilder(str).reverse().toString().equals(str);
        int l = 0;
        int r = s.length() - 1;
        if (s == null || r < 1) return true;
        
         while ( l <= r) {    
            int left = s.charAt(l);
            int right = s.charAt(r);
            
            if (isInvalid(left)) {l++; continue;}
            if (isInvalid(right)) {r--; continue;}
            
            left = getLower(left);
            right = getLower(right);

            if (left != right) return false;
            
            l++;
            r--;
            
        }
        
        return true;
    }

    private boolean isInvalid(int left) {
        return left < '0' || left > '9' && left < 'A' || left > 'Z' && left < 'a' || left > 'z';
    }

    private int getLower(int left) {
        return (left >= 'A' && left <='Z') ? left + 32 : left;
    }
/**
    private String parse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (!Character.isLetterOrDigit(temp))
                continue;
            if (Character.isLetter(temp))
                sb.append(Character.toLowerCase(temp));
            else
                sb.append(temp);
        }
        return sb.toString();
    }**/
}