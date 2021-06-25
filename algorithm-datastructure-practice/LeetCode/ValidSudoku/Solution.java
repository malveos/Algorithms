/***
 Valid Sudoku
 
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.


**/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validSubBoxes(board);
    }

    private boolean validSubBoxes(char[][] board) {
        Set<String> digs = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] != '.')
                    if(!digs.add(board[i][j] + "subbox"+ i/3 +":" + j/3)
                       || !digs.add(board[i][j] + "row"+ i)
                      || !digs.add(board[i][j] + "col"+ j)) {
                        return false;
                    }
            }
        }
        return true;
    }
}