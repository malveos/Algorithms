/***

@Author Omkar Malve

130. Surrounded Regions

Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.


***/
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length;
        int n = board[0].length;

        //Mark all connected component from all sides to new char #
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >=  board.length || j >= board[0].length)
            return;
        if (board[i][j] == 'X' || board[i][j] == '#')
            return;
        if (board[i][j] == 'O')
            board[i][j] = '#';
        
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        
    }
/*
    private boolean gotSurrounded(char[][] board, int i , int j, int m, int n) {
        return left(board, i, j) && top(board, i, j) && down(board, i, j, m) && right(board, i, j, n);
    }

    private boolean left(char[][] board, int i, int j) {
        boolean has = false;
        while(i >=0) {
            has = board[i--][j] == 'X';
            if (has) return has;
        }
        return has;
    }

    private boolean top(char[][] board, int i, int j) {
        boolean has = false;
        while(j >=0) {
            has = board[i][j--] == 'X';
            if (has) return has;
        }
        return has;
    }

    private boolean down(char[][] board, int i, int j, int m) {
        boolean has = false;
        while(i < m) {
            has = board[i++][j] == 'X';
            if (has) return has;
        }
        return has;
    }
    private boolean right(char[][] board, int i, int j, int n) {
        boolean has = false;
        while(j < n) {
            has = board[i][j++] == 'X';
            if (has) return has;
        }
        return has;
    }*/
}