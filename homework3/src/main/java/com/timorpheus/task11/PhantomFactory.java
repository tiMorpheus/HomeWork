package com.timorpheus.task11;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PhantomFactory {

    private PhantomReference<A>[] list;
    private ReferenceQueue<A> queue = new ReferenceQueue<>();
    private int capacity;
    private int count;

    private PhantomFactory(int capacity) {
        this.capacity = capacity;
        list = new PhantomReference[capacity];
    }

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public static PhantomFactory getInstance(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Min capacity");
        }

        return new PhantomFactory(capacity);
    }

    public ReferenceQueue<A> getQueue(){
        return queue;
    }

    public A loadA() {

        while (count >= capacity) {
            destruct();
        }

        A strongref = new A();

        list[count] = new PhantomReference<>(strongref, queue);
        count++;
        return strongref;

    }


    private void destruct() {
        while (queue.poll() == null) {

            System.gc();

            try {
                queue.remove(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
    }

}
