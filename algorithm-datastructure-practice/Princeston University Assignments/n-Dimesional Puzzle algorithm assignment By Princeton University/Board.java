import edu.princeton.cs.algs4.Stack;

public class Board {

    private final int size;
    private final int[] board;

    public Board(int[][] board) {
        size = board.length;

        this.board = new int[board.length * board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                this.board[i * board.length + j] = board[i][j];
            }
        }
    }

    // string representation of this board
    public String toString() {
        StringBuilder outString = new StringBuilder();
		outString.append(size);
		outString.append(System.lineSeparator());
		for (int i = 0; i < size; i++) {
		  for (int j = 0; j < size; j++) {
			outString.append(" ");
			outString.append(board[i * size + j]);
		  }
		  outString.append(System.lineSeparator());
		}

		return outString.toString();
    }

    // board dimension n
    public int dimension() {
        return size;
    }

    // number of tiles out of place
    public int hamming() {
		int distance = 0;
        for (int i = 0; i < board.length; i++) {
		  // blank square is not considered a block
		  if (board[i] != 0 && board[i] != i + 1) {
			distance++;
		  }
        }
        return distance;
    }
 
    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
		int distance = 0;
		for (int i = 0; i < board.length; i++) {
		  if (board[i] == 0) {
			continue;
		  }
		  int index = board[i] - 1;
		  index = index < 0 ? board.length - 1 : index;

		  int currentValueRow = i / (size);
		  int currentValueCol = i % (size);
		  int goalValueRow = index / (size);
		  int goalValueCol = index % (size);

		  distance += Math.abs(currentValueRow - goalValueRow) +
			  Math.abs(currentValueCol - goalValueCol);
		}
		return distance;
    }

    public boolean isGoal() {
        for (int i = 0; i < board.length; i++) {
		  if (board[i] != 0 && board[i] != i + 1) {
			return false;
		  }
		}
		return true;
    }

    // does this board equal y?
    public boolean equals(Object y) {        
        if (y == this) return true;
        if (y == null || (y.getClass() != this.getClass()) || ((Board) y).board.length != board.length) return false;

        for (int i = 0; i < board.length; i++) {
		  if (board[i] != ((Board) y).board[i]) {
			return false;
		  }
		}
        return true;    
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
       int[][] directions = new int[][] { { 1, 0 }, // BOTTOM
			{ -1, 0 }, // TOP
			{ 0, -1 }, // LEFT
			{ 0, 1 } // RIGHT
		};

		Stack<Board> neighbors = new Stack<>();

		for (int i = 0; i < board.length && neighbors.size() == 0; i++) {

		  if (board[i] != 0) {
			continue;
		  }

		  int[] blocksCopy;

		  for (int d = 0; d < directions.length; d++) {
			blocksCopy = board.clone();

			// convert index to row and column for simplicity
			int tmpi = (i / size) + directions[d][0];
			int tmpj = (i % size) + directions[d][1];

			if (isValidCoordinate(tmpi, tmpj)) {
			  int tmpVal = blocksCopy[i];
			  blocksCopy[i] = blocksCopy[tmpi * size + tmpj];
			  blocksCopy[tmpi * size + tmpj] = tmpVal;
			  neighbors.push(new Board(monoToBidi(blocksCopy)));
			}
		  }
		}

		return neighbors;
    }

    private boolean isValidCoordinate(int i, int j) {
		if (i >= 0 && i < size && j >= 0 && j < size) {
		  return true;
		}
		return false;
	}

    // a board that is obtained by exchanging any pair of tiles
   	public Board twin() {
		int[][] ttboard = monoToBidi(board);
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length - 1; col++)
                if (ttboard[row][col] != 0 && ttboard[row][col + 1] !=0)
                    return new Board(swap(row, col, row, col + 1));
        throw new RuntimeException();
    }

    private int[][] swap(int row1, int col1, int row2, int col2) {
        int[][] copy = monoToBidi(board);
        int tmp = copy[row1][col1];
        copy[row1][col1] = copy[row2][col2];
        copy[row2][col2] = tmp;
        return copy;
    }

	private int[][] monoToBidi(final int[] array) {
		int[][] bidi = new int[size][size];
		for (int i = 0; i < size; i++) {
		  System.arraycopy(array, (i * size), bidi[i], 0, size);
		}
		return bidi;
	  }

    // unit testing (not graded)
    public static void main(String[] args) {

    }

}