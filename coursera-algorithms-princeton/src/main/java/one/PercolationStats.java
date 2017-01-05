package one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * @author sunyue
 * @version 1.0    2017/1/4 16:38
 */
public class PercolationStats {
    // sample mean of percolation threshold
    private double mean;
    // sample standard deviation of percolation threshold
    private double stddev;
    // low  endpoint of 95% confidence interval
    private double confidenceLo;
    // high endpoint of 95% confidence interval
    private double confidenceHi;
    // est[i] = estimate of percolation threshold in perc[i]
    private double[] est;

    /**
     * perform trials independent experiments on an n-by-n grid
     *
     * @param n
     * @param trials
     */
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("Invalid input : n or trials musu > 0 !");
        est = new double[trials];
        for (int k = 0; k < trials; k++) {
            Percolation perc = new Percolation(n);
            double count = 0;
            while (!perc.percolates()) {
                int i = StdRandom.uniform(1, n + 1);
                int j = StdRandom.uniform(1, n + 1);
                if (perc.isOpen(i, j)) continue;
                perc.open(i, j);
                count++;
            }
            est[k] = count / (n * n);
        }
        mean = StdStats.mean(est);
        stddev = StdStats.stddev(est);
        confidenceLo = mean - (1.96 * stddev) / Math.sqrt(trials);
        confidenceHi = mean + (1.96 * stddev) / Math.sqrt(trials);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, t);
        StdOut.println("mean                    = " + stats.mean());
        StdOut.println("stddev                  = " + stats.stddev());
        StdOut.println("95% confidence interval = " + stats.confidenceLo()
                + ", " + stats.confidenceHi());
    }

    /**
     * Get sample mean of percolation threshold
     *
     * @return
     */
    public double mean() {
        return mean;
    }

    /**
     * Get sample standard deviation of percolation threshold
     *
     * @return
     */
    public double stddev() {
        return stddev;
    }


    /**
     * Get low  endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceLo() {
        return confidenceLo;
    }


    /**
     * Get high endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceHi() {
        return confidenceHi;
    }
}
