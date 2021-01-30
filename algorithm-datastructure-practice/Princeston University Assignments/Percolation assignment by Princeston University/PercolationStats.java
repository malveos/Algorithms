import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
    
    private static final double CONFIDENCE_95 = 1.96;
    private final double mean;
    private final double stddev;
    private final double confidenceLo;
    private final double confidenceHi;
    
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Invalid args");
        }
        double[] results = new double[trials];
        int tries = trials;
        while (trials > 0) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                }
                
            }
            results[trials-1] = ((double) (p.numberOfOpenSites())/(n*n));
            trials = trials -1;
        }
        this.mean = StdStats.mean(results);
        this.stddev = StdStats.stddev(results);
        this.confidenceLo = (this.mean - (CONFIDENCE_95 * this.stddev / Math.sqrt(tries)));
        this.confidenceHi = (this.mean + (CONFIDENCE_95 * this.stddev / Math.sqrt(tries)));
        
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return confidenceHi;
    }

   // test client (see below)
   public static void main(String[] args) {
       if (args.length != 2) {
           throw new IllegalArgumentException("There must be only two args.");
       }
       int n = Integer.parseInt(args[0]);
       int trials = Integer.parseInt(args[1]);
       
       PercolationStats ps = new PercolationStats(n, trials);
       StdOut.println("mean                    = " + ps.mean());
       StdOut.println("stddev                  = " + ps.stddev());
       StdOut.println("95%% confidence interval = [" + ps.confidenceLo + ", " + ps.confidenceHi + "]");
       
   }

}