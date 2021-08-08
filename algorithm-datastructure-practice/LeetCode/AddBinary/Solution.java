/***

@Author Omkar Malve


Add Binary

Given two binary strings a and b, return their sum as a binary string.

**/
class Solution {
    public String addBinary(String a, String b) {
		int m = a.length();
		int n = b.length();
           
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
         while (i >= 0 || j>= 0) {
             int add = carry;
             if (i >= 0)
                add += a.charAt(i) - '0';
             if (j >= 0) 
                 add += b.charAt(j) - '0';
            carry = add > 1 ? 1 : 0;

            ans.insert(0, add % 2);
            i--; j--;
        }
        if(carry == 1)
            ans.insert(0, "1");
        return  ans.toString();
    }
    
}