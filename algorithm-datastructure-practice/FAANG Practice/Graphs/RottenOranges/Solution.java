/***

@Author Omkar Malve

994. Rotting Oranges

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.


***/
class Solution {
    public class Index {
        public int x, y, depth;
        Index(int x, int y, int d) {
            this.x = x; this.y = y; this.depth = d;
        }
        public String toString(){
            return "[x:"+ x + ", y:" + y + ", d:"+ depth + "]";
        }
    }

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;

        Queue<Index> bfs = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j  = 0; j < c; j++) {
                if (grid[i][j] == 2)
                    bfs.add(new Index(i, j, 0));
            }
        }
        //System.out.println(" Row:" + r + ", Col:" + c);
        int ans = 0;
        //System.out.println("In the Q:" + bfs);
        while(!bfs.isEmpty()) {
            Index cur = bfs.poll();
            ans = Math.max(ans, cur.depth);
            List<Index> adjs = getAdjs(cur, r, c, grid);
            for (Index adj : adjs) {               
                grid[adj.x][adj.y] = 2;
                adj.depth = cur.depth + 1;
                //System.out.println(" Adding adj at pos: [" + adj.x + ", " + adj.y + "]");
                bfs.add(adj);

            }
        }
        for (int i = 0; i < r; i++) {
            for (int j  = 0; j < c; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return ans;
    }

    private List<Index> getAdjs(Index cur, int r, int c, int[][] grid) {
        List<Index> ans = new LinkedList<>();
        //System.out.println("finding adj at pos: [" + cur.x + ", " + cur.y + "]");
        if (cur.x + 1 >= 0 && cur.x + 1 < r && grid[cur.x + 1][cur.y] == 1)
            ans.add(new Index(cur.x + 1, cur.y, -1));
        if (cur.x - 1 >= 0 && cur.x - 1 < r && grid[cur.x - 1][cur.y] == 1)
            ans.add(new Index(cur.x - 1, cur.y, -1));
        if (cur.y + 1 >= 0 && cur.y + 1 < c && grid[cur.x][cur.y + 1] == 1)
            ans.add(new Index(cur.x, cur.y + 1, -1));
        if (cur.y - 1 >= 0 && cur.y - 1 < c && grid[cur.x][cur.y - 1] == 1)
            ans.add(new Index(cur.x, cur.y - 1, -1));
        return ans;
    }    
}