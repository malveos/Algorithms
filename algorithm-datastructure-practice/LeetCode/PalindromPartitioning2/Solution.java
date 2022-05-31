/***

@Author Omkar Malve

132. Palindrome Partitioning II

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.



****/
class Solution {
    public int minCut(String s) {
        return getByLoop(s);
    }

    private int getByLoop(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, n);

        for (int i = 0; i < n; i++) {
            check(i, i , ch, dp, n);
            check(i, i + 1 , ch, dp, n);
        }
        return dp[n - 1];
    }

    private void check(int l, int r, char[] c, int[] dp, int n) {
        while(l >=0 &&  r < n && c[l] == c[r]) {// Expand both direction
            dp[r] = Math.min(dp[r], l >= 1 ? dp[l - 1] + 1 : 0);
            l--;
            r++;
        } 
    }

    // private int getByDP(String s) {
    //     if (s == null || s.length() == 0)
    //         return 0;
    //     int n = s.length();
    //     boolean[][] dp = new boolean[n + 1][n + 1];
    //     int cut[] = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         cut[i] = i; // At least all are different
    //         for (int j = 0; j <= i; j++) {
    //             if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
    //                 dp[j][i] = true;
    //                 cut[i] = Math.min(cut[i], j == 0 ? 0 : cut[j - 1] + 1);
    //                 //System.out.println("Cut at i " + i + " is " + cut[i]);
    //             }
    //         }
    //     }
    //     return cut[n - 1];
    // }
}