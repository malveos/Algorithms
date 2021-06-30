/**

@Author Omkar Malve

N-Queens II

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.
**/
class Solution {
    public int totalNQueens(int n) {
         return solve(new boolean[n], new boolean[2*n - 1], new boolean[2*n - 1], 0);
    }

    public int solve(boolean[] colArr, boolean[] d1, boolean[] d2, int i) {
        if(i == colArr.length) {            
            return 1;
        }

        int sum = 0;
        for(int col = 0; col < colArr.length; col++) {
            // if columns is not already visited  (prevent is queen is in same column or not)
            // and i + col (left up digonal) nad i - col (right up digonal) is not marked
            if(!colArr[col] && !d1[i + col] && !d2[i - col + colArr.length - 1]) {
                colArr[col] = true;
                d1[i + col] = true;
                d2[i - col + colArr.length - 1] = true;
                sum += solve( colArr, d1, d2, i + 1);
                colArr[col] = false;
                d1[i + col] = false;
                d2[i - col + colArr.length - 1] = false;
            }
        }
        return sum;        
    }
}