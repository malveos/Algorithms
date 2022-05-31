/***

@Author Omkar Malve

474. Ones and Zeroes

You are given an array of binary strings strs and two integers m and n.
Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
A set x is a subset of a set y if all elements of x are also elements of y.

**/
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][]dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }
            System.out.println("DP\n" + print(dp));
            System.out.println("\n -----\n");
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                          System.out.println("dp["+i+"]["+j+"] =" + dp[i][j] + ", dp[ " +i+"-" +zeros+"][" +j+"-" + ones+"] + 1");
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        System.out.println("DP\n" + print(dp));
        return dp[m][n];
    }

    private String print(int[][] dp) {
        StringBuilder sb = new StringBuilder();
        for (int[] d : dp) {
            for (int x : d) {
                sb.append(x + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}