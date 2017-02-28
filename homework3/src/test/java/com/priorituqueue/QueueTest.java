package com.priorituqueue;

import com.timorpheus.priorityqueue.MySuperPriorityQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTest {

    MySuperPriorityQueue<Integer> queue;

    @Before
    public void setQueue() {
        queue = new MySuperPriorityQueue<>(Integer::compareTo);

        queue.insert(10);
        queue.insert(8);
        queue.insert(12);
        queue.insert(1);
        queue.insert(50);

    }

    @Test(expected = IllegalArgumentException.class)
    public void initWithoutComparator() {
        queue = new MySuperPriorityQueue<>(null);
    }

    @Test
    public void offerTest(){
        StringBuilder b = new StringBuilder();
        for (Integer i : queue){
            b.append(i+ " ");
        }

        assertEquals("1 8 10 12 50 ", b.toString());

    }

    @Test
    public void removeTest(){
        queue.remove();
        queue.remove();

        StringBuilder b = new StringBuilder();
        for (Integer i : queue){
            b.append(i+ " ");
        }

        assertEquals("10 12 50 ", b.toString());
    }

    @Test
    public void peekElement() {
        assertEquals(new Integer(1), queue.peek());
    }

    @Test
    public void pollTest(){
        assertEquals(new Integer(1), queue.poll());
        assertEquals(queue.size(), 4);
    }




}
