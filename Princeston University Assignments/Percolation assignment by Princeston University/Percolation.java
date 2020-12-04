import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    
    private boolean[][] grid;
    private final int n;
    private int opensites = 0;
    private final WeightedQuickUnionUF wqu;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(n + " is zero or less.");
        }

        this.n = n;
        grid = new boolean[n][n];
        wqu = new WeightedQuickUnionUF(n*n + 2); // st ed
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col)) {
            return;
        }
        row = row - 1;
        col = col - 1;
        validate(row, col);
        grid[row][col] = true;
        int id = get2DIndex(row, col);
        

        // 1.left
        if (row != 0) {
            connectAdj(row - 1, col, id);
        }
        // 2. right
        if (row != n-1) {
            connectAdj(row + 1, col, id);
        }
        // 3. upp
        if (col != 0) {
            connectAdj(row, col - 1, id);
        }
        // 4. down
        if (col != n-1) {
            connectAdj(row, col + 1, id);
        }
        
        if (row == 0) {
            wqu.union(id, n*n);
        }
        if (row == n-1) {
            wqu.union(id, n*n + 1);
        }        
        opensites += 1;
        
    }

    private void connectAdj(int r, int c, int id) {
        if (isOpen(r + 1, c + 1)) {
            wqu.union(id, get2DIndex(r, c));
        }
    }
    
    private int get2DIndex(int row, int col) {
        return (row * n + col);
    }
    
    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        row = row - 1;
        col = col - 1;
        validate(row, col);
        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        row = row - 1;
        col = col - 1;
        validate(row, col);
        return wqu.connected(n*n, get2DIndex(row, col)); // isOpen(row + 1, col + 1) && wqu.find(n*n) == wqu.find(get2DIndex(row, col));        
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return opensites;
    }

    // does the system percolate?
    public boolean percolates() {
        return wqu.find(n*n) == wqu.find(n*n + 1);
    }

  
    private void validate(int row, int col) {
        if (row < 0 || row >= n) {
            throw new IllegalArgumentException("index " + row + " is not between 0 and " + n);
        }
        if (col < 0 || col >= n) {
            throw new IllegalArgumentException("index " + col + " is not between 0 and " + n);
        }
    }
}