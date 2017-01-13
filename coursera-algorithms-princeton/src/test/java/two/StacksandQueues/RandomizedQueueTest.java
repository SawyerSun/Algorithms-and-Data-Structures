package two.StacksandQueues;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Assert;
import org.junit.Test;
import two.RandomizedQueue;

import java.util.Iterator;

/**
 * @author sunyue
 * @version 1.0    2017/1/9 18:10
 */
public class RandomizedQueueTest {
    @Test
    public void test() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        for (int i = 0; i < 10; ++i) {
            rq.enqueue(i);
        }

        Iterator<Integer> it = rq.iterator();
        while (it.hasNext()) StdOut.print(it.next() + " ");
        StdOut.println(" size: " + rq.size());
        Assert.assertEquals(10, rq.size());

        it = rq.iterator();
        while (it.hasNext()) StdOut.print(it.next() + " ");
        StdOut.println(" size: " + rq.size());
        Assert.assertEquals(10, rq.size());

        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 3; ++i) {
                rq.dequeue();
                it = rq.iterator();
                while (it.hasNext()) StdOut.print(it.next() + " ");
                StdOut.println(" size: " + rq.size());
            }
        }
    }

}