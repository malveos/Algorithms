/**

@Author Omkar Malve

Maximal Rectangle

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

**/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;

        int maxArea = Integer.MIN_VALUE;
        int height[] = new int[matrix[0].length];
        
        // adding each rows ans calculate area till that row and then merge it with next row
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0;j < matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    height[j] = 0;
                } else height[j]++;
            }
            maxArea = Math.max(maxArea, findHistArea(height));
            //System.out.println("Max:" + maxArea);
        }
        //System.out.println(" Height Array becomes: ");
        //printArray(height);
       return maxArea;
    }

    private int findHistArea(int[] height){
        if(height == null || height.length == 0) return 0;
        Stack<Integer> s = new Stack<>();
        int lb = 0, rb = 0, top = 0, area = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        //System.out.println(" Finding Area of - ");
        //printArray(height);
        for(int i = 0; i < height.length; i++){
            while(!s.isEmpty() && height[s.peek()] > height[i]) { // pop if prev is greater than current
                rb = i; // current index
                top = s.pop(); // maxHeight
                lb = s.isEmpty() ? -1 : s.peek(); // left prev highest Histogram
                area = height[top] * (rb - lb -1);
          //      System.out.println("New Area: ht * (rb -lb - 1): " +height[top] + " * (" + rb + " " + lb + " )");
                max = Math.max(max, area);
            }
            s.push(i);
        }

        // process if stack not empty
        rb = height.length;
        while(!s.isEmpty()) {
            top = s.pop();
            lb = s.isEmpty() ? -1 : s.peek();
            area = height[top] * (rb - lb - 1);
            //System.out.println("Out loop New Area: ht * (rb -lb - 1): " +height[top] + " * (" + rb + " " + lb + " )");
            max = Math.max(max, area);
        }
        return max;
    }
    
    private void printArray(int[] h) {
        for (int i =0; i< h.length; i++) 
            System.out.print(h[i] + " ");
    }
}