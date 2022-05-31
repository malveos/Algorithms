/***

@Author Omkar Malve

354. Russian Doll Envelopes

You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

***/
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return Integer.compare(b[1], a[1]);    
                return Integer.compare(a[0], b[0]);
            }
        });
        int[] dp = new int[envelopes.length];
        int ans = 0;
        for (int[] env : envelopes) { // sorted by first so find second
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, ans, height);
            if (left < 0) left = -left - 1;
            if (left == ans) ans++;
            dp[left] = height;
        }
        return ans;
    }
}