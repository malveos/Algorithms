/***
Sudoku Solver

**/

class Solution {
    // Following are to maintain a possible values present at rows, columns or subbox.
    public boolean[][] rows = new boolean[9][9];
    public boolean[][] cols = new boolean[9][9];
    public boolean[][] subboxes = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for(int i = 0; i<9; i++) {
            for(int j = 0; j<9; j++) {
                if(board[i][j] != '.') {
                    int pos = board[i][j] - '1'; // make it zero index
                    int subboxStart = (i/3) * 3 + j/3; // find ith position for the 3x3 box
                    rows[i][pos] = cols[j][pos] = subboxes[subboxStart][pos] = true;
                }                    
            }   
        }
        solve(board, 0 , 0);
    }

    private boolean solve(char[][] board, int i, int j) {
        if( j == 9)
            if (i == 8)
                return true;
            else {
                i = i + 1; j = 0;
            }
    
        // Iterate throsugh validation rows and check if we can add that value
        if(board[i][j] == '.') {
            int newI = (i/3)*3 + j/3;
            for (int pos = 0; pos<9; pos++) {
                if(!rows[i][pos] && !cols[j][pos] && !subboxes[newI][pos]) {
                    
                    board[i][j] = (char)( pos + '1');
                    rows[i][pos] = true;
                    cols[j][pos] = true;
                    subboxes[newI][pos] = true; 
                    
                    // check if its next is true
                    if(solve(board,i,j+1)){
                        return true;
                    }

                    board[i][j] = '.';
                    rows[i][pos] = false;
                    cols[j][pos] = false;
                    subboxes[newI][pos] = false;
                }
            }
            return false;
        }
        return solve(board, i, j + 1);
    }
    
    private void print(boolean[][] arr){
         for(int i = 0; i<9; i++) {
            for(int j = 0; j<9; j++) {
                System.out.print(arr[i][j] + " ");       
            }
            System.out.println();
         }
    }
}