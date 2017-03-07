package com.task15;

import com.timorpheus.task15.MyPriorityQueue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class QueueTest {
    MyPriorityQueue queue;
    Comparator<Integer> comparator;

    @Before
    public void setUp(){
        comparator = Integer::compareTo;
        queue = new MyPriorityQueue(comparator);

        queue.offer(10);
        queue.offer(0);
        queue.offer(30);
        queue.offer(50);
        queue.offer(5);

    }

    @After
    public void clearUp(){
        queue = new MyPriorityQueue(comparator);
    }

    @Test
    public void addTest(){
        for (int i = 0; i < 95; i++) {
                queue.offer(i);
        }
        assertEquals(100, queue.size());
    }

    @Test
    public void peekTest(){
        assertEquals(0,queue.peek());
        assertEquals(5, queue.size());

    }

    @Test
    public void pollTest(){

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.poll());
        }
    }


}
