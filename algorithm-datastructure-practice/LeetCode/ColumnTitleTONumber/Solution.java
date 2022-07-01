/***

@Author Omkar Malve

171. Excel Sheet Column Number

Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.


***/
class Solution {
    public int titleToNumber(String columnTitle) {
        int ans= 0;;
        for (int i = 0; i < columnTitle.length(); i++)
            ans = ans * 26 + (int) (columnTitle.charAt(i) - 'A') + 1;            
        return ans;
    }
}