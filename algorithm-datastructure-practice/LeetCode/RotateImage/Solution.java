/**

@Author Omkar Malve

Rotate Image

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.


**/
class Solution {
    public void rotate(int[][] matrix) {
        // transpose  matrix and then sqap columns from left/right while go to center
        transpose(matrix);
        colSwap(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void colSwap(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int leftCol = 0;
            int rightCol = matrix.length - 1;
            while (leftCol < rightCol) {
                swap(matrix, i, leftCol, i, rightCol);
                leftCol++;
                rightCol--;
            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}