package two.StacksandQueues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author sunyue
 * @version 1.0    2017/1/9 18:19
 */
public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        String[] strs = StdIn.readAllStrings();
        StdRandom.shuffle(strs);
        for (int i = 0; i < k; i++) {
            rq.enqueue(strs[i]);
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(rq.dequeue());
        }
    }
}
