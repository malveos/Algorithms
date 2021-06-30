/**
 @Author Omkar Malve
 
 N-Queens
 
 
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
**/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> possibleSols = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // fillup initial values
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        // solve by recursionand backtracking
        solveBoard(possibleSols, board, n, n, 0);
        return possibleSols;
    }

    private void solveBoard(List<List<String>> possibleSols, char[][] board, int len, int rowNum, int start) {
        // base case
        if (rowNum == 0) {
            // add all rows in answer
            List<String> rowList = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                rowList.add(new String(board[i]));
            }
            possibleSols.add(rowList);
            return;
        }
        if (start == len) 
            return;

        // checke for each pos if we can place Queen or not
        for (int i = 0; i < len; i++) {
            board[start][i] = 'Q';
            if (validQueenPosition(board, start, i, len)) {
                solveBoard(possibleSols, board, len, rowNum - 1, start + 1);
            }
            board[start][i] = '.';
        }
        return;
    }

    private boolean validQueenPosition(char[][] board, int r, int c, int len) {
        // check for vertical above if Queen exists
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < len; j++) { // processing all rowes above and all columns
                if (board[i][j] == 'Q') {
                    if (j == c)
                        return false;
                    else {
                        for (int dig = 1; dig <= r - i; dig++) {
                            // all rows  and columns will go digonaly up both sides to check
                            if (r == (i + dig) && ( c == j + dig || c == j - dig)) {
                                // if ( r == 2 && c == 2)
                                //     System.out.println(" i :" + i + "dig:" + dig + " j: " + j);
                                return false;
                            }                                
                        }
                    }
                }
            }
        }
        return true;
    }
}