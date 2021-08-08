/**

@Author Omkar Malve

Unique Paths II

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.
**/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length + 1;
        int n = obstacleGrid[0].length + 1;
        int[][] dp = new int[m][n];
        dp[1][1] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                } else if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}