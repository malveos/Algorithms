/***
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).


***/

class Solution {
    public int myAtoi(String s) {
        //s = s.strip();
        s = s.trim();
        int digit = 0;
        int sign = 1;
        if (null == s || s.length() < 1) return digit;

        //System.out.println(s);
        boolean isFirst = true;
        for (char c: s.toCharArray()) {
            if (isFirst && (c == '+' || c == '-'))
                sign = (c == '-') ? -1 : 1;
            else if (isDigit(c)) {
                if (digit > Integer.MAX_VALUE/10 || (digit == Integer.MAX_VALUE/10 && (c - '0') > Integer.MAX_VALUE%10)) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
                }
              digit = digit * 10 + (c - '0') ;  
            } else {
                break;
            }
            isFirst = false;
        }
        return (digit * sign);
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
} 