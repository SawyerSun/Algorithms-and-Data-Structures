package two.StacksandQueues;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Assert;
import org.junit.Test;
import two.Deque;

import java.util.Iterator;

/**
 * @author sunyue
 * @version 1.0    2017/1/9 17:10
 */
public class DequeTest {
    @Test
    public void test1(){
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i <6 ; i+=2) {
            deque.addFirst(i);
            deque.addLast(i+1);
        }

        Iterator<Integer> it = deque.iterator();
        while (it.hasNext()){
            StdOut.print(it.next()+" ");
        }
        StdOut.println(" size = "+deque.size());
        Assert.assertEquals(6,deque.size());

        for (int i = 0; i <3; i++) {
            deque.removeFirst();
            deque.removeLast();
        }
        StdOut.println("size = "+ deque.size());
        Assert.assertEquals(0,deque.size());
    }

    @Test
    public void test2(){
        Deque<Integer> deque = new Deque<>();
        Assert.assertEquals(true,deque.isEmpty());
        deque.addFirst(4);
        Assert.assertEquals(false,deque.isEmpty());
        deque.removeFirst();
        Assert.assertEquals(true,deque.isEmpty());
    }
}