/***

@Auhor Omkar Malve

120. Triangle

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

***/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int l = triangle.size();
        int[][] dp = new int[l][l];
        int ps = Integer.MAX_VALUE;

        // Fill dp for calculations // left below half triangel
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i < j)
                   dp[i][j] = Integer.MAX_VALUE;
                else
                    dp[i][j] = triangle.get(i).get(j);
            }
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i < j)
                    continue;
                if (i == 0 && j == 0)
                    dp[i][j] = triangle.get(i).get(j);
                else  {
                    // int top = i - 1 < j ? triangle.get(i - 1).get(j - 1) : triangle.get(i - 1).get(j);
                    // int topleft = (j - 1) >=0 ? triangle.get(i - 1).get(j - 1) : triangle.get(i - 1).get(j); 
                    // System.out.println("topleft:" + topleft + "  ;top :" + top);
                    // dp[i][j] = triangle.get(i).get(j) + Math.min(top, topleft);

                    int top = dp[i - 1][j];
                    int topleft = (j - 1) >=0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                    //System.out.println("topleft:" + topleft + "  ;top :" + top);
                    dp[i][j] += Math.min(top, topleft);
                }
                if (i == l - 1)
                    ps = Math.min(ps, dp[i][j]);
            }
        }
        return ps;
    }

    /*
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) return 0;
        int ps = 0;
        int minI = 0;
        for (List<Integer> row : triangle) {
            minI = row.get(minI) <= (minI + 1 < row.size() ? row.get(minI + 1) : row.get(minI)) ? minI : minI + 1;
            ps += row.get(minI);
        }
        return ps;
    }**/
}