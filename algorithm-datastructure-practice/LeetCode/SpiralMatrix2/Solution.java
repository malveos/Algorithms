/***

@Author Omkar Malve

Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
**/
class Solution {
    public int[][] generateMatrix(int n) {
     
        int i = 0; 
        int j = 0;
        int[][] matrix = new int[n][n];
        int val = 1;
        int r = matrix.length - 1;
        int c = matrix[0].length -1;
        
        while (i <= r && j <= c) {
            // top left to right
            for (int runner = j; runner <= c; runner++)
                matrix[i][runner] = val++;
            i++; // move to second row

            // right top to bottom
            for (int runner = i; runner <= r; runner++)
                matrix[runner][c] = val++;
            c--; // making col to 1 pos left

            // right bottom to left
            for (int runner = c; runner >= j; runner--)
                matrix[r][runner] = val++;
            r--; // make one row less

            // left bottom to top
            for (int runner = r; runner >= i; runner--)
                matrix[runner][j] = val++;
            j++;
        }
        return matrix;
    }
}