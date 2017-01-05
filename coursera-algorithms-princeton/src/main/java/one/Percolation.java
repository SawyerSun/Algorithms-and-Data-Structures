package one; /**
 * @author sunyue
 * @version 1.0    2017/1/4 16:38
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    // number of grid should be n +1，because row and column indices are between 1 and n
    private int n;
    // union-find data structure
    private WeightedQuickUnionUF uf;
    // mark open site
    // 0 for Blocked site, 1 for Open site, 2 for Open site connected to the bottom
    private byte[][] open;
    // number of open sites
    private int num;

    /**
     * create n-by-n grid, with all sites blocked.
     *
     * @param n number of dimension
     */
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("Invalid input : n must > 0 !");
        this.n = n + 1;
        uf = new WeightedQuickUnionUF(this.n * this.n);
        open = new byte[this.n][this.n];
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        Percolation percolation = new Percolation(n);
        boolean isPercolated = false;
        int count = 0;
        while (!in.isEmpty()) {
            int row = in.readInt();
            int col = in.readInt();
            if (!percolation.isOpen(row, col)) {
                count++;
            }
            percolation.open(row, col);
            isPercolated = percolation.percolates();
            if (isPercolated) {
                break;
            }
        }
        StdOut.println(count + " open sites");
        if (isPercolated) {
            StdOut.println("percolates");
        } else {
            StdOut.println("does not percolate");
        }

    }

    /**
     * Validate the row and col indices.
     *
     * @param row row index
     * @param col col index
     */
    private void validate(int row, int col) {
        if (row <= 0 || row >= n) {
            throw new IndexOutOfBoundsException("Invalid input : row index out of bounds !");
        }
        if (col <= 0 || row >= n) {
            throw new IndexOutOfBoundsException("Invalid input : col index out of bounds !");
        }
    }

    /**
     * open site (row, col) if it is not open already
     *
     * @param row the index of row
     * @param col the index of column
     */
    public void open(int row, int col) {
        validate(row, col);
        // is open already
        if (isOpen(row, col)) return;
        // make this site open
        open[row][col] = 1;
        num++;
        // we make 0 represent the virtual-top, 1 represent the virtual-bottom.
        // is the bottom row
        if (row == n -1) open[row][col] = 2;
        // is the top row
        if (row == 1) {
            uf.union(0, row * n + col);
            // 1-by-1 grid corner case
            if (open[row][col] == 2) open[0][0] = 2;
        }
        // above site is open
        if (row - 1 > 0 && isOpen(row - 1, col)) {
            update(row - 1, col, row, col);
        }
        // below site is open
        if (row + 1 < n && isOpen(row + 1, col)) {
            update(row + 1, col, row, col);
        }
        // left site is open
        if (col - 1 > 0 && isOpen(row, col - 1)) {
            update(row, col - 1, row, col);
        }
        // right site is open
        if (col + 1 < n && isOpen(row, col + 1)) {
            update(row, col + 1, row, col);
        }
    }

    /**
     * update components: connect the opened site to all of its adjacent open sites
     *
     * @param i1 adjacent open site row index
     * @param j1 adjacent open site col index
     * @param i2 the opened site row index
     * @param j2 the opened site col index
     */
    private void update(int i1, int j1, int i2, int j2) {
        int p = uf.find(i1 * n + j1);
        int q = uf.find(i2 * n + j2);
        uf.union(i1 * n + j1, i2 * n + j2);
        // if one of them is connected to bottom, then the updated component is connected to bottom too.
        if (open[p / n][p % n] == 2 || open[q / n][q % n] == 2) {
            int t = uf.find(i2 * n + j2);
            open[t / n][t % n] = 2;
        }
    }

    /**
     * is site (row, col) open?
     *
     * @param row row index
     * @param col col index
     * @return
     */
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return open[row][col] > 0;
    }

    /**
     * is site (row, col) full?
     *
     * @param row row index
     * @param col col index
     * @return
     */
    public boolean isFull(int row, int col) {
        validate(row, col);
        return open[row][col] > 0 && uf.connected(0, row * n + col);
    }

    /**
     * number of open sites
     *
     * @return
     */
    public int numberOfOpenSites() {
        return num;
    }

    /**
     * does the system percolate?
     *
     * @return
     */
    public boolean percolates() {
        int root = uf.find(0);
        return open[root / n][root % n] == 2;
    }


}
