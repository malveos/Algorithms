import java.util.LinkedList;

public class Board {

    private static final int SPACE = 0;
    private final int[][] board;
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        board = copy(tiles);
    }

    private int[][] copy(int[][] arr) {
        int [][] temp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }

    // string representation of this board
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dimension() + "\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                sb.append(String.format("%2d ", board[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return board.length;
    }

    // number of tiles out of place
    public int hamming() {
        int ct = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (blockNotAtDreamLocation(i, j))
                  ct++;
            }
        }
        return ct;
    }
 
    private boolean blockNotAtDreamLocation(int r, int c) {
        int block = board[r][c];

        return !isSpace(block) && block != goalFor(r, c);
    }

    private boolean isSpace(int loc) {
        return loc == SPACE;
    }

    private int goalFor(int r, int c) {
        return r * dimension() + c + 1;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
		int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                sum += getDist(i, j);
            }
        }
        return sum;
    }

    private int getDist(int r, int c) {
        int val = board[r][c];
        return isSpace(val) ? 0 : Math.abs(r - ((r-1)/dimension())) + Math.abs(c - ((c-1) % dimension()));
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                 if (blockNotAtDreamLocation(i, j)) return false;
            }
        }
        return true;
    }

    // does this board equal y?
    public boolean equals(Object y) {        
        if (y == this) return true;
        if (y == null || (y.getClass() != this.getClass()) || ((Board) y).board.length != board.length) return false;

        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++)
                if (((Board) y).board[row][col] != board[row][col]) return false;
        return true;    
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
         LinkedList<Board> neighbors = new LinkedList<Board>();

        int[] location = spaceLocation();
        int spaceRow = location[0];
        int spaceCol = location[1];

        if (spaceRow > 0)               neighbors.add(new Board(swap(spaceRow, spaceCol, spaceRow - 1, spaceCol)));
        if (spaceRow < dimension() - 1) neighbors.add(new Board(swap(spaceRow, spaceCol, spaceRow + 1, spaceCol)));
        if (spaceCol > 0)               neighbors.add(new Board(swap(spaceRow, spaceCol, spaceRow, spaceCol - 1)));
        if (spaceCol < dimension() - 1) neighbors.add(new Board(swap(spaceRow, spaceCol, spaceRow, spaceCol + 1)));

        return neighbors;
    }

    private int[] spaceLocation() {
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++)
                if (isSpace(board[row][col])) {
                    int[] location = new int[2];
                    location[0] = row;
                    location[1] = col;
                    return location;
                }
        throw new RuntimeException();
    }
    // a board that is obtained by exchanging any pair of tiles
   public Board twin() {
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length - 1; col++)
                if (!isSpace(board[row][col]) && !isSpace(board[row][col + 1]))
                    return new Board(swap(row, col, row, col + 1));
        throw new RuntimeException();
    }

    private int[][] swap(int row1, int col1, int row2, int col2) {
        int[][] copy = copy(board);
        int tmp = copy[row1][col1];
        copy[row1][col1] = copy[row2][col2];
        copy[row2][col2] = tmp;
        return copy;
    }

    // unit testing (not graded)
    public static void main(String[] args) {

    }

}