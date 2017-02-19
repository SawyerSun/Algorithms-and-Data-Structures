package Four;

import edu.princeton.cs.algs4.MinPQ;

import java.util.Comparator;
import java.util.Stack;

/**
 * @author sunyue
 * @version 1.0    2017/2/18 15:36
 */
public class Solver {
    private int count = 0;
    private MinPQ<Node> pq1;
    private MinPQ<Node> pq2;
    private Comparator<Node> manhattanPriority = new ManhattanPriority();

    /**
     * find a solution to the initial board (using the A* algorithm)
     *
     * @param initial
     */
    public Solver(Board initial) {
        pq1 = new MinPQ<>(manhattanPriority);
        pq2 = new MinPQ<>(manhattanPriority);
        pq1.insert(new Node(initial, count, null));
        pq2.insert(new Node(initial.twin(), count, null));
        Node cur1;
        Node cur2;
        while (!pq1.min().board.isGoal() && !pq2.min().board.isGoal()) {
            cur1 = pq1.delMin();
            cur2 = pq2.delMin();
            for (Board board : cur1.board.neighbors()) {
                if (null != cur1.prev && board.equals(cur1.prev.board)) continue;
                pq1.insert(new Node(board, cur1.moves + 1, cur1));
            }
            for (Board board : cur2.board.neighbors()) {
                if (null != cur2.prev && board.equals(cur2.prev.board)) continue;
                pq2.insert(new Node(board, cur2.moves + 1, cur2));
            }
        }
        if (!pq1.min().board.isGoal()) count = -1;
        else count = pq1.min().moves;
    }

    /**
     * solve a slider puzzle (given below)
     *
     * @param args
     */
    public static void main(String[] args) {
    }

    /**
     * is the initial board solvable?
     *
     * @return
     */

    public boolean isSolvable() {
        return count != -1;
    }

    /**
     * min number of moves to solve initial board; -1 if unsolvable
     *
     * @return
     */
    public int moves() {
        return count;
    }

    /**
     * sequence of boards in a shortest solution; null if unsolvable
     *
     * @return
     */
    public Iterable<Board> solution() {
        if (!isSolvable()) return null;
        Stack<Board> stack = new Stack<>();
        Node path = pq1.min();
        while (path != null) {
            stack.push(path.board);
            path = path.prev;
        }
        return stack;
    }

    private class Node {
        private Board board;
        private int moves;
        private Node prev;

        public Node(Board board, int moves, Node prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
        }
    }

    private class ManhattanPriority implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            int num1 = o1.board.manhattan() + o1.moves;
            int num2 = o2.board.manhattan() + o2.moves;
            if (num1 == num2) {
                if (o1.board.hamming() == o2.board.hamming()) return 0;
                if (o1.board.hamming() < o2.board.hamming()) return -1;
                return 1;
            }
            if (num1 < num2) return -1;
            return 1;
        }
    }
}
