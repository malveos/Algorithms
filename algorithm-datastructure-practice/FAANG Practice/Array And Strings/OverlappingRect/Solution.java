/***

@Author Omkar Malve

836. Rectangle Overlap

An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.

Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.


**/
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        // we can check if one rectangle is around the other in four directions.
        //
        //
        //                          x0 y0
        //
        //           x1 y1   n0 m1   ----------- n1 m1
        //                          |         |
        //                  n0 m0   ----------- n1 m0       x0 y0
        //
        //                                    x1 y1
        //
        //
        
        
        int x0 = rec2[0],  y0 = rec2[1],  x1 = rec2[2], y1 = rec2[3] ;
        int n0 = rec1[0],  m0 = rec1[1],  n1 = rec1[2], m1 = rec1[3] ;
        
         return !( x1 <= n0 ||  n1 <= x0 || m1 <= y0 || y1 <= m0);
    }
}