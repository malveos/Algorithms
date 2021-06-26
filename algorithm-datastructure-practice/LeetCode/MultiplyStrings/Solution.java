/**
@Author Omkar Malve


 Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
**/
class Solution {
    public String multiply(String num1, String num2) {
        // base cases
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.equals("1"))
            return num2;
        if (num2.equals("1"))
            return num1;
        
        int n1 = num1.length();
        int n2 = num2.length();
        String[] sum = new String[n1 + n2];
        for (int i = 0; i < sum.length; i++)
            sum[i] = "0";
        
        for (int i = n1 - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = n2- 1; j >= 0; j--) {
                int a1 = Character.getNumericValue(num1.charAt(i));
                int a2 = Character.getNumericValue(num2.charAt(j));
                int value = Integer.valueOf(sum[i + j + 1]) + a1 * a2 + carry;
                sum[i + j + 1] = String.valueOf(value % 10);
                carry = value/10;
            
            }
            sum[i] += carry;
        }
        
        //printArray(sum);
        
        String ans = "";
        return Stream.of(sum).collect(Collectors.joining("")).replaceFirst("^0+(?!$)", "");
    }
    
    private void printArray(String [] a) {
        for (String s : a)
            System.out.print(s);
    }
}