package com.timorpheus.task8and9;


public class MySingleList<E> implements IList<E> {

    private Node head;
    private Node tail;
    private int size;

    private class Node<E> {
        Node next;
        E data;

        Node(E data) {
            this.data = data;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public MySingleList() {
        size = 0;
    }

    @Override
    public void add(E element) {

        Node<E> a = new Node<>(element);

        if (tail == null) {
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
        size++;
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
        size++;

    }

    @Override
    public void remove(int index) {
        checkElementIndex(index);

        if (index == 0) {
            head = head.next;
            size--;
        } else if (index == size - 1) {
            Node<E> newTail = getNodeByIndex(index - 1);
            tail = newTail;
            newTail.next = null;
            size--;
        } else {

            Node<E> prev = getNodeByIndex(index - 1);
            Node<E> removed = getNodeByIndex(index);
            Node<E> after = removed.next;

            prev.next = after;
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
        return (E) getNodeByIndex(index).data;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNodeByIndex(index);
        E removedData = node.data;
        node.data = element;
        return removedData;
    }

    @Override
    public void clear() {
        this.head = tail.next;

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
                if (x.data == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = head; x != null; x = x.next) {
                if (element.equals(x.data))
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
            stringBuilder.append(t.data + " ");
            t = t.next;
        }
        return stringBuilder.toString();
    }

}
