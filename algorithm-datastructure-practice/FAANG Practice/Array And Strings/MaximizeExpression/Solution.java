/***

@Author Omkar Malve


1131. Maximum of Absolute Value Expression

Given two arrays of integers with equal lengths, return the maximum value of:

|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|

where the maximum is taken over all 0 <= i, j < arr1.length.



**/

class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int a1 = Integer.MIN_VALUE;
        int a2 = Integer.MAX_VALUE;
        int b1 = Integer.MIN_VALUE;
        int b2 = Integer.MAX_VALUE;
        int c1 = Integer.MIN_VALUE;
        int c2 = Integer.MAX_VALUE;
        int d1 = Integer.MIN_VALUE;
        int d2 = Integer.MAX_VALUE;
        
        for (int i = 0; i <n; i++) {
            if (a1 < arr1[i] + arr2[i] + i)
                a1 = arr1[i] + arr2[i] + i;
            if (a2 > arr1[i] + arr2[i] + i)
                a2 = arr1[i] + arr2[i] + i;
            
            if (b1 < -arr1[i] + arr2[i] + i)
                b1 = -arr1[i] + arr2[i] + i;
            if (b2 > -arr1[i] + arr2[i] + i)
                b2 = -arr1[i] + arr2[i] + i;
            
            if (c1 < arr1[i] + arr2[i] - i)
                c1 = arr1[i] + arr2[i] - i;
            if (c2 > arr1[i] + arr2[i] - i)
                c2 = arr1[i] + arr2[i] - i;

            if (d1 < -arr1[i] + arr2[i] - i)
                d1 = -arr1[i] + arr2[i] - i;
            if (d2 > -arr1[i] + arr2[i] - i)
                d2 = -arr1[i] + arr2[i] - i;
        }
        int max1 = a1 - a2 > b1 - b2 ? a1 - a2 : b1 - b2;
        int max2 = c1 - c2 > d1 - d2 ? c1 - c2 : d1 - d2;
        return max1 > max2 ? max1 : max2;
    }
}