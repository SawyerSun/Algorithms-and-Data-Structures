package four;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunyue
 * @version 1.0    2017/2/18 15:31
 */
public class Board {
    // char[]比int[]需要更少的空间
    private char[] cells;
    private int dimension;
    private int zero;
    private int hamming;
    private int manhattan;

    /**
     * construct a board from an n-by-n array of blocks (where blocks[i][j] = block in row i, column j)
     *
     * @param blocks
     */
    public Board(int[][] blocks) {
        dimension = blocks.length;
        cells = new char[dimension * dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cells[i * dimension + j] = (char) blocks[i][j];
                if (cells[i * dimension + j] == 0) {
                    zero = i * dimension + j;
                }
            }
        }
        hamming = calHamming(cells);
        manhattan = calManhattan(cells);
    }

    private Board(char[] cells, int dimension, int zero, int hamming, int manhattan) {
        this.dimension = dimension;
        this.cells = cells;
        this.zero = zero;
        this.hamming = hamming;
        this.manhattan = manhattan;
    }

    // unit tests
    public static void main(String[] args) {
        In in = new In(args[0]);
        int size = in.readInt();
        int[][] blocks = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                blocks[i][j] = in.readInt();
        Board b = new Board(blocks);
        StdOut.println(b);
        System.out.println(b.hamming);
        for (Board board : b.neighbors()) {
            System.out.println(board);
            System.out.println(b.hamming);
        }
    }

    /**
     * board dimension n
     *
     * @return
     */
    public int dimension() {
        return dimension;
    }

    /**
     * number of blocks out of place
     *
     * @return
     */
    public int hamming() {
        return hamming;
    }

    /**
     * sum of Manhattan distances between blocks and goal
     *
     * @return
     */
    public int manhattan() {
        return manhattan;
    }

    /**
     * is this board the goal board?
     *
     * @return
     */
    public boolean isGoal() {
        return hamming == 0;
    }

    /**
     * a board that is obtained by exchanging any pair of blocks
     *
     * @return
     */
    public Board twin() {
        char[] copy = cells.clone();
        for (int i = 0; i < cells.length; i++) {
            // 第一列 或者 相邻元素有0 除外
            if (i % dimension == 0 || cells[i] * cells[i - 1] == 0) continue;
            exch(copy, i, i - 1);
            int h = hamming;
            int m = manhattan;
            for (int j = i; j > i - 2; j--) {
                h += calHamming(copy[j], j) - calHamming(cells[j], j);
                m += calManhattan(copy[j], j) - calManhattan(cells[j], j);
            }
            return new Board(copy, dimension, zero, h, m);
        }
        return null;
    }

    /**
     * does this board equal y?
     *
     * @param y
     * @return
     */
    @Override
    public boolean equals(Object y) {
        if (null == y || this.getClass() != y.getClass()) {
            return false;
        }
        return new String(cells).equals(new String(((Board) y).cells));
    }

    /**
     * all neighboring boards
     *
     * @return
     */
    public Iterable<Board> neighbors() {
        List<Board> neighbours = new ArrayList<>();
        // 空格向上
        if (zero / dimension != 0) {
            neighbours.add(neighbour(zero - dimension));
        }
        // 空格向下
        if (zero / dimension != (dimension - 1)) {
            neighbours.add(neighbour(zero + dimension));
        }
        // 空格向左
        if (zero % dimension != 0) {
            neighbours.add(neighbour(zero - 1));
        }
        // 空格向右
        if (zero % dimension != (dimension - 1)) {
            neighbours.add(neighbour(zero + 1));
        }
        return neighbours;
    }

    /**
     * string representation of this board (in the output format specified below)
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(dimension + " \n ");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                s.append(String.format("%d ", (int) cells[i * dimension + j]));
            }
            s.append("\n ");
        }
        return s.toString();
    }

    private int calHamming(char[] chars) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            count += calHamming(chars[i], i);
        }
        return count;
    }

    private int calHamming(char c, int i) {
        if (c == 0) return 0;
        if (c != (i + 1)) return 1;
        return 0;
    }

    private int calManhattan(char[] chars) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            count += calManhattan(chars[i], i);
        }
        return count;
    }

    private int calManhattan(char c, int i) {
        if (c == 0) return 0;
        return Math.abs(i / dimension - (c - 1) / dimension) + Math.abs(i % dimension - (c - 1) % dimension);
    }

    private void exch(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private Board neighbour(int i) {
        char[] copy = cells.clone();
        exch(copy, zero, i);
        int h = hamming;
        int m = manhattan;
        h += calHamming(copy[zero], zero) - calHamming(copy[i], i);
        m += calManhattan(copy[zero], zero) - calManhattan(copy[i], i);
        return new Board(copy, dimension, i, h, m);
    }
}
