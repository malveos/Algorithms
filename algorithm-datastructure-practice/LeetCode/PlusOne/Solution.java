/***
@Author Omkar Malve

 Plus One
 
Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.


**/
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;
        
        for (int i = n - 1; i>=0; i--) {
            if (i == n -1) {
                if(digits[i] + 1 > 9) {
                    int num = digits[i] + 1 ;
                    carry = 1;
                    digits[i] = num %10;                
                } else {
                    digits[i] += 1;
                }    
            } else if (carry != 0) {
                 if(digits[i] + carry > 9) {
                    int num = digits[i] + carry;
                    carry = 1;
                    digits[i] = num %10;                
                } else {
                    digits[i] += 1;
                     carry = 0;
                }
                
            }
        }
        if (carry == 1) { // there is need to add new elem in array
            int temp[] = new int[n + 1];
            temp [0] = 1;
            for (int i = 1; i <n + 1; i++) {
                temp[i] = digits[i - 1];
            }
            return temp;
        }
        return digits;
    }
}