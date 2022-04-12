/***

@Author Omkar Malve

221. Maximal Square

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

**/
class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 && n == 0) return 0;
        // for sqaure checking form bottom righht
        int ans = 0;
        int [][]dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j>= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = matrix[i][j] - '0'; // base case
                } else {
                    if (matrix[i][j] - '0' == 0) {
                        dp[i][j] = 0;
                    } else {
                        // cheking of right, bottom, dig-right-down has square or not
                        dp[i][j] = 1 + Math.min(dp[i + 1][j + 1] , Math.min(dp[i + 1][j], dp[i][j + 1]));
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        //print(dp);
        return ans * ans; 
    }

//     private void print(int[][] dp) {
//         for(int[] a : dp){
//             System.out.println("");
//             for(int e : a){ 
//                 System.out.print(" "  + e);
//             }
//         }
//     }
}