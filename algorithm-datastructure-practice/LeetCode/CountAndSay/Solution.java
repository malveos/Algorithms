/**
Count and Say

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.

**/
class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        if(n == 2) {
            return "11";
        }
        return countIfRepeat(countAndSay(n- 1), 1);
    }
    
    private String countIfRepeat(String s, int ct) {
        if (s.length() == 1)
            return String.valueOf(ct) + s;
        
        // cheeck if repeating
        if(s.charAt(0) == s.charAt(1)) {
            return countIfRepeat(s.substring(1), ct + 1);
        } else {
            return String.valueOf(ct) + s.charAt(0) + countIfRepeat(s.substring(1), 1);
        }
    }
}