/***

@Author Omkar Malve

37. Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

***/
public class Solution {
	private int size;
	public int[][] solve(int[][] matrix, int sz) {
		this.size = sz;	
		if (!sisSolvable(matrix, 0, 0)){
			throw new Exception("Unable to solve sudoku");
		}			
			
		return matrix;
	}
	
	private boolean isSolvable(int [][] matrix, int i, int j) {
		// Base case : check if it is a boundary
		if (j == size) return isSolvable(matrix, i+1, 0);
		if (i == size) return true;

		if (matrix[i][j] == "0") {
			// check is any number we can add here
			for (int n =1; n<size; n++){
				if (isValidN(matrix, i, j, n)) {
					matrix[i][j] = n;
					boolean solved = isSolvable(matrix, i , j+1);
					if (solved) return true;
					matrix[i][j] = "0";
				}
			}
			return false;
		} else {
			return isSolvable(matrix, i, j+1);
		}
	}
	
	private isValidN(int[][] matrix, int i, int j, int n){
		// chek if it is in row or col or in grid
		for (int k = 0; k<size; k++){
			if (matrix[i][k] == n || matrix[k][j] == n) {
				return false;
			}
		}
		int sqrt = Math.sqrt(size);
		int gridR = (i/sqrt)*sqrt;
		int gridC = (j/sqrt)*sqrt;
		for (int k =gridR; k<gridR + sqrt ; k++){
			for (int l =gridC; l<gridC + sqrt; l++){
				if (matrix[k][l] == n)
					return false;
			}
		}
		return true;
	}
}