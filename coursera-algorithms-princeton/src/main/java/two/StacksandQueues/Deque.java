package two.StacksandQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author sunyue
 * @version 1.0    2017/1/9 16:23
 */
public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    // null node
    // 一开始使用null而不是null Node，各种错误。
    private Node nul;
    private int size;

    /**
     * construct an empty deque
     */
    public Deque() {
        nul = new Node(null, null, null);
        first = nul;
        last = nul;
        size = 0;
    }

    /**
     * is the deque empty?
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return first.item == null && last.item == null;
    }

    /**
     * return the number of items on the deque
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * add the item to the front
     *
     * @param item which to be added to the front
     */
    public void addFirst(Item item) {
        if (null == item) throw new NullPointerException("Can't add null to the deque!");
        Node newFirst = new Node(nul, first, item);
        if (isEmpty()) {
            last = newFirst;
            first = newFirst;
        } else {
            first.prev = newFirst;
            first = newFirst;
        }
        size++;
    }

    /**
     * add the item to the end
     *
     * @param item which to be added to the end
     */
    public void addLast(Item item) {
        if (item == null) throw new NullPointerException("Can't add null to the deque!");
        Node newLast = new Node(last, nul, item);
        if (isEmpty()) {
            first = newLast;
            last = newLast;
        } else {
            last.next = newLast;
            last = newLast;
        }
        size++;
    }

    /**
     * remove and return the item from the front
     *
     * @return item which to be removed from the front
     */
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("The deque is empty!");
        Item item = first.item;
        first = first.next;
        // is only one item
        if (first.item == null) {
            last = nul;
        }else {
            first.prev = nul;
        }
        size--;
        return item;
    }

    /**
     * remove and return the item from the end
     *
     * @return item which to be removed from the end
     */
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("The deque is empty!");
        Item item = last.item;
        last = last.prev;
        // is only one item
        if (last.item == null) {
            first = nul;
        }else {
            last.next = nul;
        }
        size--;
        return item;
    }

    /**
     * return an iterator over items in order from front to end
     *
     * @return Iterator
     */
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("There is no more items!");
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operator is unsupported!");
        }
    }

    private class Node {
        private Node prev;
        private Node next;
        private Item item;

        Node(Node prev, Node next, Item item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }
}
