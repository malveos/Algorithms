/***

@Author Omkar Malve

695. Max Area of Island

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

***/
class Solution {
    private static final int[] xm = {-1, 1, 0, 0};
    private static final int[] ym = { 0, 0, -1, 1};

    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        if (r == 0) return 0;
        int c = grid[0].length;

        int maxA = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, r, c, grid);
                    maxA = Math.max(area, maxA);
                }
            }
        }
        return maxA;
    }

    private int dfs(int i, int j, int r, int c, int [][] grid) {
        grid[i][j] = '0';// mark as visited
        int ct = 1;// Current
        for (int p = 0; p < 4; p++) {
            int nx = i + xm[p];
            int ny = j + ym[p];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && grid[nx][ny] == 1 )
                ct += dfs(nx, ny, r, c, grid);
        }
        return ct;
    }
}