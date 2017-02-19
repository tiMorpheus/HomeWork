package com.timorpheus.task11;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomFactory {

    public static ReferenceQueue<A> queue = new ReferenceQueue<>();
    private static int capacity;
    private static int count;

    public static int getCount() {
        return count;
    }

    public PhantomFactory(int capacity) {
        this.capacity = capacity;
    }

    public A loadA(int a) throws InterruptedException {
        while (true) {
            if (count < capacity) {

                A pa = new A(a);
                wrapA(pa);
                return pa;
            } else {
                Reference<A> reference = (Reference<A>) queue.remove(100);
                if (reference != null) {
                    System.out.println("remove old object");
                    count--;
                }
            }
            return null;
        }
    }


    private PhantomReference<A> wrapA(A a) {
        PhantomReference<A> reference = new PhantomReference<>(a, queue);

        count++;
        return reference;
    }
}
