/***

@Author Omakr Malve

200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



***/
class Solution {
    private static final int[] xm = {-1, 1, 0, 0};
    private static final int[] ym = { 0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        int r = grid.length;
        if (r == 0) return 0;
        int c = grid[0].length;

        int noi = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] - '0' == 1) {
                    dfs(i, j, r, c, grid);
                    noi++;
                }
            }
        }
        return noi;
    }

    private void dfs(int i, int j, int r, int c, char [][] grid) {
        grid[i][j] = '0';// mark as visited
        for (int p = 0; p < 4; p++) {
            int nx = i + xm[p];
            int ny = j + ym[p];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && grid[nx][ny] - '0' == 1 )
                dfs(nx, ny, r, c, grid);
        }
    }
}