                                 /**

@Author Omkar Malve

1074. Number of Submatrices That Sum to Target

Given a matrix and a target, return the number of non-empty submatrices that sum to target.
A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.

***/

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
       return getByPefixSumCombo(matrix, target);
    }

    public int getByPefixSumCombo(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;                                     
  
        for (int i = 0; i < m; i++) {                 
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {

                // calculate prefix sum for row
                for (int col = 0; col < n; col++) {
                    //System.out.println("Adding " + matrix[j][col] + " at [" + j + "," + col + "] to " + sum[col]);
                    sum[col] += matrix[j][col];
                }
                //System.out.println("Prefix sum for column " +j + "  is :" +   Arrays.toString(sum));
                // traverse left and right boundary
                for (int left = 0; left < n; left++) {
                    int cnt = 0;
                    for (int indexer = left; indexer < n; indexer++) {
                        cnt += sum[indexer];
                        //System.out.println("Count:" + cnt);
                        if (cnt == target) res++;
                    }
                }
            }
            
            //System.out.println("\n\n New location");
        }
        return res;
    }

    private int ByMatrixCalculations(int[][] matrix, int target) {
        int count = 0;
        int line = matrix.length;
        int column = matrix[0].length + 1;
        int[][] sum = new int[line][column];
        
        for (int i = 0; i < sum.length; i++){
            for (int j = 1; j < sum[0].length; j++){
                sum[i][j] = sum[i][j - 1] + matrix[i][j - 1];
            }
        }
        // Added one column of zero to take care index out of bounds
        //System.out.println("MatrixSum : " + Arrays.deepToString(sum));
        
        for (int start = 0; start < column; start++){
            for (int end = start + 1; end < column; end++ ){
                // Do for every starting of matrix from left topcorner      
                int sumOfSubMatrix = 0;
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                map.put(0, 1);
                for(int l = 0; l < line; l++){
                    //System.out.println("Start:" + start + " End="+ end + " l=" + l + "");
                    
                    
                    // Sum of matrix of the range between start to end for the column l
                    sumOfSubMatrix += sum[l][end] - sum[l][start];
                    if (map.containsKey(sumOfSubMatrix - target)) {
                        count += map.get(sumOfSubMatrix - target);
                        //System.out.println("Found:" + map + "\n" + sum[l][end]  + " - " + sum[l][start]);
                    }
                    map.put(sumOfSubMatrix, map.getOrDefault(sumOfSubMatrix, 0) + 1);
                    
                }
            }
        }
        
        return count;
    }
}