/****

@Author Omkar Malve

286. Walls and Gates


***/
class Solution {
	public private int WALL = -1;
	public private int GATE = 0;
	public private int ROOM = 2147483647;
	
	public int [] xm = {-1, -1, 0, 0};
	public int [] ym = {0, 0, 1, -1};

	public class CELL {
		public int x, y;
		CELL(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public void getMinDistanceMatrix(int [][] rooms) {
		int n = rooms.length;
		if (n == 0) return;
		int m = rooms[0].length;
		Queue<CELL> bfs = new LinkedList<>();

		// Add all gates to the Q at start
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (rooms[i][j] == GATE)
					bfs.add(new CELL(i, j));
			}
		}

		while (!bfs.isEmpty()) {
			CELL cur = bfs.poll();
			// check neighbours
			for (int i = 0 ; i < 4; i++){
				int nx = cur.x + xm[i];
				int ny = cur.y + ym[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && rooms[nx][ny] == ROOM) {
					bfs.add(new CELL(nx, ny));
					rooms[nx][ny] = Math.min(rooms[cur.x][cur.y] + 1, rooms[nx][ny]);
				}
			}
		}
	}
}