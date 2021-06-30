/**

@Author Omkar Malve

Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.
**/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new LinkedList<>();
        int r = 0, c = 0, startPos = 0; // (00) (11) (22)
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int maxLen = rowLen * colLen;
        while(maxLen > 0) {
            r = c = startPos;
            while (c < colLen && maxLen > 0) {
               answer.add(matrix[r][c++]);
               maxLen--;
            }
            r++; c--; // to make index back on track 
            while (r < rowLen && maxLen > 0)  {
                answer.add(matrix[r++][c]);
                maxLen--;
            }
            r--; c--; // to make index back on track 
            while (c >= startPos && maxLen > 0) {
                answer.add(matrix[r][c--]);
                maxLen--;
            }
            r--; c++; // to make index back on track 
            while (r > startPos && maxLen > 0) {
                answer.add(matrix[r--][c]);
                maxLen--;
            }

            // reset start index for next spiral
            startPos++;
            rowLen--;
            colLen--;            
        }
        return answer;
    }
}