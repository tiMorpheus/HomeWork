package com.timorpheus.task15;

import java.util.*;

public class MyPriorityQueue<E> {

    private Object[] queue;
    private int size;
    private final Comparator<? super E> comparator;
    private int modCount = 0;

    //Constructor
    public MyPriorityQueue(Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.queue = new Object[11];
    }

    public int size() {
        return size;
    }

    /**
     * Increases the capacity of the array.
     */
    private void resize() {

        int oldCapacity = queue.length;
        // Double size if small; else resize by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ? (oldCapacity + 2) : (oldCapacity >> 1));
        queue = Arrays.copyOf(queue, newCapacity);
    }

    public boolean offer(E e) {
        if (e == null) {
            throw new IllegalArgumentException("arg is null");
        }

        if (size >= queue.length - 1) {
            resize();
        }

        if (size == 0) {
            queue[0] = e;
        } else {
            siftUp(size, e);
        }

        modCount++;
        size++;

        return true;
    }

    /**
     * Inserts item x at position k, maintaining heap invariant by
     * promoting x up the tree until it is greater than or equal to
     * its parent, or is the root.
     *
     * @param k the position to fill
     * @param x the item to insert
     */
    private void siftUp(int k, E x) {
        while (k > 0) {

            int parent = (k - 1) >>> 1;

            Object e = queue[parent];

            if (comparator.compare(x, (E) e) >= 0) {
                break;
            }

            queue[k] = e;
            k = parent;
        }

        queue[k] = x;
    }


    public E peek() {
        return (size == 0) ? null : (E) queue[0];
    }

    /**
     * Removes the element from start of this priority queue.
     */
    public E poll() {

        if (size == 0) {
            return null;
        }

        int s = --size;

        modCount++;

        E result = (E) queue[0];

        E x = (E) queue[s];

        queue[s] = null;
        if (s != 0) {
            siftDown(0, x);
        }
        return result;
    }

    /**
     * Inserts item x at position k, maintaining heap invariant by
     * demoting x down the tree repeatedly until it is less than or
     * equal to its children or is a leaf.
     *
     * @param k the position to fill
     * @param x the item to insert
     */
    private void siftDown(int k, E x) {

        int half = size >>> 1;

        while (k < half) {

            int child = (k << 1) + 1;

            Object c = queue[child];

            int right = child + 1;

            if (right < size && comparator.compare((E) c, (E) queue[right]) > 0) {
                c = queue[child = right];
            }

            if (comparator.compare(x, (E) c) <= 0) {
                break;
            }

            queue[k] = c;

            k = child;
        }

        queue[k] = x;
    }

    public Iterator iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private int cursor = 0;
        private int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor < size;
        }

        public E next() {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException();
            if (cursor < size)
                return (E) queue[cursor++];
            else  throw new NoSuchElementException();
        }
    }

}
