package com.timorpheus.task8and9;

public class MySingleList<E> implements IList<E>{

    private ListElement head;
    private ListElement tail;

    private class ListElement<E> {
        ListElement next;
        E data;
    }

    @Override
    public void add(E data) {
        ListElement a = new ListElement();
        a.data = data;

        if (head == null) {
            head = a;
            tail = a;
        } else {
            a.next = head;
            head = a;
        }
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public void remove(E data) {

        // empty list
        if (head == null) {
            return;
        }

        // single element
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        // first element
        if (head.data == data) {
            head = head.next;
            return;
        }

        // start search
        ListElement t = head;
        while (t.next != null) {
            if (t.next.data == data) {
                if (tail == t.next) {
                    tail = t;
                }
                t.next = t.next.next;
                return;
            }
            t = t.next;       // next
        }
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

}
