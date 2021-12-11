/****

@Author Omkar Malve

498. Diagonal Traverse

Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.


***/
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        int m = mat[0].length, n = mat.length, r = 0, c = 0, dir = 1;
        int[] ans = new int [m * n];
        
        // traverse from top to continue
        for (int i = 0; i<m *n; i++) {
            ans[i] = mat[r][c]; 
            if (dir == 1) { // UPWARD
                if (c == m - 1) { //at right side then slide below and down
                    r++;
                    dir = -1; 
                } else if (r == 0) { // start row then slide right and down
                    c++; 
                    dir = -1;
                } else { // In the middle
                    r--;
                    c++;
                }
            } else { // DOWNWARD
                if (r == n - 1) { // at bottom then slide right and up
                    c++;
                    dir = 1;
                } else if (c == 0) { // at left then slide below and up
                    r++;
                    dir = 1;
                } else { // In the middle
                    c--;
                    r++;
                }
            }
        }
        return ans;
        
    }
}