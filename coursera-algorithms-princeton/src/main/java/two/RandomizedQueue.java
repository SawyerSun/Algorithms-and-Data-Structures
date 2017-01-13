package two;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author sunyue
 * @version 1.0    2017/1/9 17:46
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;

    /**
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
        this.size = 0;
        this.items = (Item[]) new Object[1];
    }

    /**
     * is the queue empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the number of items on the queue
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * add the item
     *
     * @param item
     */
    public void enqueue(Item item) {
        if (null == item) throw new NullPointerException("Can't enqueue null value!");
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[size++] = item;
    }

    /**
     * resize the queue
     *
     * @param capacity
     */
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    /**
     * remove and return a random item
     *
     * @return
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("The queue is empty!");
        if (size == items.length / 4) {
            resize(items.length / 2);
        }
        int random = StdRandom.uniform(size);
        Item item = items[random];
        items[random] = items[--size];
        items[size] = null;
        return item;
    }

    /**
     * return (but do not remove) a random item
     *
     * @return
     */
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("The queue is empty!");
        return items[StdRandom.uniform(size)];
    }

    /**
     * return an independent iterator over items in random order
     *
     * @return
     */
    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }


    private class RandomizedQueueIterator implements Iterator<Item> {
        private int[] random;
        private int current;

        public RandomizedQueueIterator() {
            this.random = new int[size];
            for (int i = 0; i < size; i++) {
                random[i] = i;
            }
            StdRandom.shuffle(random);
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return current != random.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("There is no more items!");
            return items[random[current++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operator is unsupported!");
        }
    }
}
