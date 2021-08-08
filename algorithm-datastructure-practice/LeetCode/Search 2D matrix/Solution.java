/***

@Author Omkar Malve

 Search a 2D Matrix


**/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return binarySearch(matrix, target);
    }
    
    private boolean linearSearch(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }   
        }
        return false;
    }
    private boolean binarySearch(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;
        
        int len = m * n;
        
        int low = 0;
        int high = len - 1;
        
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int x = mid / m;
            int y = mid % m;
            
            int pick = matrix[x][y];
            if (pick == target) return true;
            else if (target < pick) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}