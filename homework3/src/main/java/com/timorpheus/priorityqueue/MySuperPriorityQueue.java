package com.timorpheus.priorityqueue;


import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySuperPriorityQueue<E> implements Iterable<E> {

    private E[] queue;
    private int size;
    private Comparator<E> comparator;
    private int modCount = 0;


    public MySuperPriorityQueue(Comparator<E> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("comparator is needed");
        }
        this.comparator = comparator;
        queue = (E[]) new Object[11];
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     *  Retrieves, but does not remove, the head of this queue, or returns {@code null} if this queue is empty
     *
     *  @return E root of binary heap or {@code null} if this queue is empty
     * */
    public E peek() {

        return isEmpty() ? null : queue[1];
    }

    public E poll(){
        if (isEmpty()){
            return null;
        }

        return remove();
    }


    // helper function to double the size of the heap array
    private void resize(int capacity) {

        E[] temp = (E[]) new Object[capacity];

        for (int i = 1; i <= size; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }

    /**
     * Adds a new element to this priority queue.
     *
     * @param x the new element to add to this priority queue
     */
    public void insert(E x) {

        if (x == null){
            throw new IllegalArgumentException("null cannot be inserted into a queue");
        }

        modCount++;
        // double size of array if necessary
        if (size >= queue.length - 1) {
            resize(2 * queue.length);
        }

        // add x, and percolate it up to maintain heap invariant
        queue[++size] = x;
        swim(size);

    }


    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }

        swapElements(1, size);
        modCount++;
        E min = queue[size--];
        sink(1);
        queue[size + 1] = null;

        if ((size > 0) && (size == (queue.length - 1) / 4)) {
            resize(queue.length / 2);
        }



        return min;
    }


    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swapElements(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {

            int j = 2 * k;

            if (j < size && greater(j, j + 1)) {
                j++;
            }

            if (!greater(k, j)) {
                break;
            }

            swapElements(k, j);

            k = j;
        }
    }

    private boolean greater(int i, int j) {

        return comparator.compare(queue[i], queue[j]) > 0;
    }

    private void swapElements(int i, int j) {
        E swap = queue[i];
        queue[i] = queue[j];
        queue[j] = swap;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }


    private class Itr implements Iterator<E> {

        private MySuperPriorityQueue<E> copy;
        private int expectedModCount = modCount;


        public Itr() {
            copy = new MySuperPriorityQueue<E>(comparator);
            for (int i = 1; i <= size; i++)
                copy.insert(queue[i]);
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public E next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.remove();
        }
    }
}
