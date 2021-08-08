/***

@Author Omkar Malve

Word Searc

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.


**/
class Solution {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean res = dfs(board, i, j, word, word.length() - 1, new boolean[board.length][board[0].length]);
                if (res) return true;
            }
        }
        return false;
    }
    
     private boolean dfs(char[][] board, int i, int j, String word, int size, boolean[][] visited) {
        if (size < 0)
            return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != word.charAt(size) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        size--;

         // Sequence is important
        boolean up = dfs(board, i, j+1, word, size, visited);
        boolean right = dfs(board, i+1, j, word, size, visited);
        boolean down = dfs(board, i, j-1, word, size, visited);
        boolean left = dfs(board, i-1, j, word, size, visited);
        
        return up || right || left || down;
    }
}