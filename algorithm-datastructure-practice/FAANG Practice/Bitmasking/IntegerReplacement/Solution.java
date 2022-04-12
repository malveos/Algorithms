/***

@Author Omkar malve

397. Integer Replacement

Given a positive integer n, you can apply one of the following operations:

If n is even, replace n with n / 2.
If n is odd, replace n with either n + 1 or n - 1.
Return the minimum number of operations needed for n to become 1.



***/
class Solution {
    public int integerReplacement(int n) {
     
        if (n == 1) return 0;       
        if (n == Integer.MAX_VALUE) return 32;

        if ((n & 1) == 0) {// divide till the possible
            return integerReplacement(n >> 1) + 1;
        }
        if (n == 3 || n % 4 == 1) { // near 3 multiple CAn try to make it 2 by subs            
            return integerReplacement(n - 1) + 1;
        }
        return integerReplacement(n + 1) + 1;
    }
}