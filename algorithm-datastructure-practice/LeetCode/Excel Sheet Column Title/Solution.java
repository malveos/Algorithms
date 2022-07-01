/***

@Author Omkar Malve

168. Excel Sheet Column Title

Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.


**/

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while(columnNumber > 0) {
            int remainder = columnNumber%26;
            //System.out.println("ColumnNumber is " + columnNumber + " And rem is "+ remainder);
            ans.insert(0, getAlphabet(remainder == 0 ? 26 : remainder));
            columnNumber -= remainder == 0 ? 26 : remainder;
            columnNumber /= (26);
        }
        return ans.toString();
    }

    private Character getAlphabet(int i) {
        Character val = (char)(i + 'A' - 1);
        //System.out.println("Got " + val +  " for the " + i);
        return val;
    }
}