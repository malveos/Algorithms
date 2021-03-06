/**
ZigZag Conversion


1 to n from top to bottom and then come ack to top one char by char

*/
class Solution {
    public String convert(String s, int numRows) {
        if (null == s || s.length() < 1 || numRows == 1) return s;
        StringBuilder response = new StringBuilder();
        // cycle means n-1 in row and then go back to top for next cycle
        int cycle =  2 * numRows - 2;

        for (int i = 0; i< numRows; i++) {
            for (int j = 0; j + i < s.length(); j+=cycle) {
                response.append(s.charAt(j + i));

                if (i != 0 && i != numRows - 1 && j + cycle - i < s.length())
                    response.append(s.charAt(j + cycle - i));
            }   
        }

        return response.toString();
    }
}