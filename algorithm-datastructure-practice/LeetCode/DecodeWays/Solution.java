
/***

@Author Omkar Malve

91. Decode Ways

A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

***/
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.charAt(0) == '0') return 0;
        
        if (s.length()== 1) return 1;
        
        int singleC = 1;
        int doubleC = 1;

        for (int i =1; i<s.length(); i++) {
            int curDigit = s.charAt(i) - '0';
            int doubleDigit = (s.charAt(i - 1) - '0')  * 10 + curDigit;
            int count = 0;            
            if (curDigit >0) {
                count = singleC;// possiblility of single
            }
            
            if (doubleDigit >=10 && doubleDigit <=26) {
                count += doubleC; // double possibility
            }
            
            doubleC = singleC; // double need previous single ways
            singleC = count; // single need all ways
        }
        return singleC;
    }
}