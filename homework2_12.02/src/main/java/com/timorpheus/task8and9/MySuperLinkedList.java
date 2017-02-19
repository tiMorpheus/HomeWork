package com.timorpheus.task8and9;


import java.util.ConcurrentModificationException;
import java.util.ListIterator;

public class MySuperLinkedList<E> implements IList<E> {

    private Node<E> first;
    private Node<E> last;
    int size = 0;
    protected int modificationCount = 0;


    public MySuperLinkedList() {
    }

    @Override
    public void add(E element) {

        addLast(element);
    }

    private void addLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        modificationCount++;
        size++;
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (element == null){
            throw new IllegalArgumentException();
        }

        if (index == size) {
            addLast(element);
        } else {
            insertNodeBefore(element, getNodeByIndex(index));
        }

    }


    private Node<E> getNodeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index < (size >> 1)) {  // from first to last
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {                 //from last ot first
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    @Override
    public void remove(int index) {
        checkElementIndex(index);
        removeNode(getNodeByIndex(index));
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return getNodeByIndex(index).element;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = getNodeByIndex(index);
        E oldValue = x.element;
        x.element = element;
        modificationCount++;

        return oldValue;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.element = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
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



    void insertNodeBefore(E e, Node<E> nod) {

        final Node<E> pred = nod.prev;
        final Node<E> newNode = new Node<>(pred, e, nod);
        nod.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        modificationCount++;
        size++;

    }

    E removeNode(Node<E> x) {

        final E element = x.element;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.element = null;
        modificationCount++;
        size--;

        return element;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.element == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (element.equals(x.element)) {
                    return index;
                }
                index++;

            }
        }
        return -1;
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

    public ListIterator<E> iterator(int index) {
        checkPositionIndex(index);
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        private int expectedModificationCount = modificationCount;


        ListItr(int index) {

            next = (index == size) ? null : getNodeByIndex(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            checkForComodification();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.element;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public E previous() {
            checkForComodification();

            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.element;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            
        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }


        final void checkForComodification() {
            if (modificationCount != expectedModificationCount)
                throw new ConcurrentModificationException();
        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    '}';
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node t = first;
        while (t != null) {
            stringBuilder.append(t.element + " ");
            t = t.next;
        }

        return stringBuilder.toString();
    }
}
