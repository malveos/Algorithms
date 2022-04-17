/***

@Author Omkar Malve

1197. Knight Moves to target


**/
public class Solution {
    public int[] xm = {1, 1, -1, -1, 2, 2, -2, -2};
    public int[] ym = {2, -2, 2, -2, 1, -1, 1, -1};
    public class Cell {
        public int x, y;
        public int d;
        public Cell(int x, int y, int d) {
            this.x = x; this.y = y; this.d = d;
        }
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        boolean [][] visited =  new boolean[A + 1][B + 1];
        //Arrays.fill(visited, false);
        Queue<Cell> bfs = new LinkedList<>();
        bfs.add(new Cell(C, D, 0));
        visited[C][D] = true;

        while (!bfs.isEmpty()) {
            Cell cur = bfs.poll();
            //System.out.println("Currently at :[ " + cur.x + ", " + cur.y + "] at depth =" + cur.d);
            if (cur.x == E && cur.y == F)
                return cur.d;
            for (int k = 0; k < 8; k++) {
                int nx = cur.x + xm[k];
                int ny = cur.y + ym[k];
                if (nx > 0 && nx <= A && ny > 0 && ny <= B && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    bfs.add(new Cell(nx, ny, cur.d + 1));
                }
            }
        }
        return -1;
    }
}
