/***

@Author Omkar Malve

Set Matrix Zeroes
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

You must do it in place.


***/

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[] rows = new boolean[r];
        boolean[] cols = new boolean[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }   
        }
        //print(matrix);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rows[i] || cols[j]) {
                     matrix[i][j] = 0;
                }
            }   
        }
    }
    
    private void print(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
