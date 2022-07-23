/***

@Author Omkar Malve


1473. Paint House III

There is a row of m houses in a small city, each house must be painted with one of the n colors (labeled from 1 to n), some houses that have been painted last summer should not be painted again.

A neighborhood is a maximal group of continuous houses that are painted with the same color.

For example: houses = [1,2,2,3,3,2,1,1] contains 5 neighborhoods [{1}, {2,2}, {3,3}, {2}, {1,1}].
Given an array houses, an m x n matrix cost and an integer target where:

houses[i]: is the color of the house i, and 0 if the house is not painted yet.
cost[i][j]: is the cost of paint the house i with the color j + 1.
Return the minimum cost of painting all the remaining houses in such a way that there are exactly target neighborhoods. If it is not possible, return -1.


**/
class Solution {
    Integer[][][] cache = new Integer[101][21][101];
    int LARGE = 100000000;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) { 
        int ans = getMin(houses, cost, 0, 0, target, m, n);
        return ans >= LARGE ? -1 : ans;
    }

    // process to end of houses and checking if cost is minimum
    private int getMin(int[] h, int[][] c, int houseCur, int color, int target, int m, int n) {
        //System.out.println("Going in for [" + houseCur + "," + color + "," + target + "]");
        if (houseCur == m || target < 0) {
            int v = target == 0 ? 0 : LARGE;
            //System.out.println("Returning for color" + color + " at houseI:" + houseCur + "  value=" + (v) + "  target:"+target);
            return v;
        }
        
        if (cache[houseCur][color][target] != null) return cache[houseCur][color][target];

        // check if it has colored
        if (h[houseCur] != 0) {
            //System.out.println("Already colored " + color + " at houseI:" + houseCur + "  target:"+target);
            return cache[houseCur][color][target] = getMin(h, c, houseCur + 1, h[houseCur], target - (h[houseCur] != color ? 1 : 0), m, n);
        }
        
        // how check which color section will bring cost down
        int ans = LARGE;
        for (int col = 1; col <= n; col++) {
            int newTarget = target - (col == color ? 0 : 1);
            int afterCost = getMin(h, c, houseCur + 1, col, newTarget, m, n);
            ans = Math.min(afterCost + c[houseCur][col - 1], ans);
        }
       // System.out.println("New Color" + color + " at houseI:" + houseCur + "  target:"+target + " with MinCost:" + ans);
        return cache[houseCur][color][target] = ans;
    }
}