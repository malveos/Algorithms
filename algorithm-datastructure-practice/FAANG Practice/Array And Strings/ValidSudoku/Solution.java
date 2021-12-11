/***

@Author Omakr Malve

36. Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


**/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>(9);
        List<Set<Character>> cols = new ArrayList<>(9);
        List<Set<Character>> subBoxes = new ArrayList<>(9);
        
        for (int i = 0; i < 9 ; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            subBoxes.add(new HashSet<>());
        }
        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9 ; j++) {
                Character c = board[i][j];
                if (c == '.')
                    continue;
                int boxIndex = (i/3) *  3 + (j/3);
                if (!(rows.get(i).add(c) && cols.get(j).add(c) && subBoxes.get(boxIndex).add(c)))
                    return false;
            }
        }
        return true;
    }
}