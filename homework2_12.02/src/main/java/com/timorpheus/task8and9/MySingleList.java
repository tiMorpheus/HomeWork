package com.timorpheus.task8and9;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MySingleList<E> implements IList<E>, Iterable<E> {

    private Node head;
    private int size;
    protected int modificationCount = 0;

    public MySingleList() {
        size = 0;
    }

    @Override
    public void add(E element) {
        add(size(), element);
    }


    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == 0) {
            Node<E> newHead = head;
            head = new Node(element);
            head.next = newHead;
        } else {
            Node<E> pre = getNodeByIndex(index - 1);
            Node<E> current = pre.next;
            Node<E> newNode = new Node<>(element);
            pre.next = newNode;
            newNode.next = current;
        }
        modificationCount++;
        size++;
    }

    @Override
    public void remove(int index) {
        checkElementIndex(index);

        if (index == 0) {
            head = head.next;
            modificationCount++;

            size--;
        } else if (index == size - 1) {
            Node<E> newTail = getNodeByIndex(index - 1);

            newTail.next = null;
            modificationCount++;

            size--;
        } else {

            Node<E> prev = getNodeByIndex(index - 1);
            Node<E> removed = getNodeByIndex(index);
            Node<E> after = removed.next;

            prev.next = after;
            modificationCount++;
            size--;
        }
    }

    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }


    @Override
    public E get(int index) {
        checkPositionIndex(index);
        return (E) getNodeByIndex(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNodeByIndex(index);
        E removedData = node.element;
        node.element = element;
        modificationCount++;
        return removedData;
    }

    @Override
    public void clear() {

        this.head = getNodeByIndex(size - 1).next;

        modificationCount++;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size() != 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> x = head; x != null; x = x.next) {
                if (x.element == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = head; x != null; x = x.next) {
                if (element.equals(x.element))
                    return index;
                index++;
            }
        }
        return -1;
    }

    private Node getNodeByIndex(int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node t = head;
        while (t != null) {
            stringBuilder.append(t.element + " ");
            t = t.next;
        }

        return stringBuilder.toString();
    }


    public Iterator<E> iterator() {
        return new Itr(head);
    }

    private class Itr<E> implements Iterator<E> {
        private Node<E> current = head;
        private int expectedModificationCount = modificationCount;

        public Itr(Node<E> head) {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = current.element;
            current = current.next;
            return element;
        }

        final void checkForComodification() {
            if (modificationCount != expectedModificationCount)
                throw new ConcurrentModificationException();
        }
    }

    private class Node<E> {
        Node next;
        E element;

        Node(E element) {
            this.element = element;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    '}';
        }
    }

}
