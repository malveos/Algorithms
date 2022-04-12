/***

@Author Omkar Malve

72. Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

***/
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] cache = new int[m + 1][n + 1];
        for (int[] a : cache)
            Arrays.fill(a, -1);
        return minD(word1, word2, m, n, cache);        
    }

    private int minD(String w1, String w2, int m, int n, int [][] cache) {
        if (n == 0) return m;
        if (m == 0) return n;
        if (cache[m][n] != -1) return cache[m][n];

        if(w1.charAt(m - 1) == w2.charAt(n - 1))
            return cache[m][n] = minD(w1, w2, m - 1, n - 1, cache);
        int insert = minD(w1, w2, m, n - 1, cache);
        int delete = minD(w1, w2, m - 1, n, cache);
        int update = minD(w1, w2, m - 1, n - 1, cache);
        
        return cache[m][n] = 1 +  Math.min(insert, Math.min(delete, update));
    }
}