/****

@Author Omkar Malve

279. Perfect Squares

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.


***/
class Solution {
    private boolean isSquare(int n) { 
        int s = squareRoot(n);       
        return s * s == n;
    }

    private int squareRoot(int n) {
         return (int) Math.sqrt(n);
    }

    private boolean isSumOfFourIntegers(int n) { 
        while(n % 4== 0)n /=4;
        return n % 8 == 7;
    }

    private boolean isSumOfSquares(int n) { 
        for (int i = 1; i <= squareRoot(n); i++) {
            if (isSquare(n - (i * i))) return true;
        }
        return false;
    }

    public int numSquares(int n) { 
        
        // Theorem of square
        if (n == 0) return 0;
        if (isSquare(n)) return 1;
        if (isSumOfFourIntegers(n)) return 4;
        if (isSumOfSquares(n)) return 2;
        return 3;
        
        /***
        int []dp = new int[n + 1];
        dp[0] = 0;        
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int sq = 1; sq * sq <= i; sq++) {
                min = Math.min(min, dp[i - sq * sq]);
            }
            dp[i] = min + 1; // one for current
        }
        return dp[n];
        
        **/
    }
}