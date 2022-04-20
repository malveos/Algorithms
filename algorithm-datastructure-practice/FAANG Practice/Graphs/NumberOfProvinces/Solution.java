/***

@Author Omkar Malve

547. Number of Provinces

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.


**/
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int r = isConnected.length;
        int c = isConnected[0].length;

        boolean []visited = new boolean[r];
        int groupCount = 0;

        for (int i = 0; i < r; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                groupCount++;
            }
        }
        return groupCount;
    }

    private void dfs(int st, int[][] matrix, boolean[] vis) {
        vis[st] = true;
        for (int f = 0; f < matrix.length; f++) {
            if (!vis[f] && f != st && matrix[f][st] == 1) {// if cur is friend with other
                dfs(f, matrix, vis);
            }
        }
    }
}