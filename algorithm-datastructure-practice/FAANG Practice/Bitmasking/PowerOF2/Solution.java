/***

@Author Omkar Malve

231. Power of Two

Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.


**/
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n <= 0 ? false :(n & -n) == n;
        /*int count = 0;
        while(n > 0) {
            if ((n & 1) == 1)
                count++;
            n >>= 1;// right shift to chek with 1
        }
        return count == 1;*/
    }
}