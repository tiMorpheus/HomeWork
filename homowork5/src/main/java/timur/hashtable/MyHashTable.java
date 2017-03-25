package timur.hashtable;

import com.sun.istack.internal.Nullable;

import java.util.Hashtable;

public class MyHashTable<K, V> {

    private int size = 0;

    private Node<K, V>[] hashTable;

    private class Node<K, V> {
        final int hash;
        K key;
        V value;
        Node next;

        Node(K key, V value) {
            this.hash = hash(key.hashCode());
            this.key = key;
            this.value = value;
        }

        boolean hasNext() {
            return next != null;
        }
    }

    public MyHashTable() {
        hashTable = new Node[16];
    }

    public MyHashTable(int capacity) {
        hashTable = new Node[capacity];
    }


    public synchronized V put(K key, V value) {

        if (containsKey(key)) {
            return null;
        }
        ensureCapacity(size + 1);
        size++;
        return putNode(new Node<>(key, value));
    }

    @Nullable
    private V putNode(Node<K, V> node) {
        int position = getPosition(node.hash);

        V returnValue = null;

        if (hashTable[position] == null) {
            hashTable[position] = node;
        } else {
            if (containsKey(node.key)) {
                Node<K, V> tmpNode = hashTable[node.hash];

                while (tmpNode.hasNext()) {

                    if (tmpNode.key == node.key) {
                        returnValue = tmpNode.value;
                        tmpNode.value = node.value;
                    }

                    tmpNode = tmpNode.next;
                }

                if (tmpNode.key == node.key) {
                    returnValue = tmpNode.value;
                    tmpNode.value = node.value;
                }
            } else {
                Node<K, V> tmpNode = hashTable[node.hash];
                hashTable[position] = node;
                node.next = tmpNode;
            }
        }


        return returnValue;
    }

    @Nullable
    public synchronized V get(K key) {
        int position = getPosition(hash(key.hashCode()));
        Node<K, V> node = hashTable[position];

        if (node != null) {
            while (node.hasNext()) {
                if (node.key.equals(key)) {
                    return node.value;
                }

                node = node.next;
            }

            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }

    @Nullable
    public synchronized V remote(K key) {
        int position = getPosition(key.hashCode());
        Node<K, V> node = hashTable[position];

        V returnValue = null;

        if (node != null) {
            if (node.key.equals(key)) {
                returnValue = node.value;

                hashTable[position] = node.next;
                size--;
            }

            while (node.hasNext()) {
                if (node.key.equals(key)) {
                    returnValue = node.value;

                    hashTable[position] = node.next;
                    size--;
                }
            }
        }


        return returnValue;
    }

    public synchronized boolean containsKey(K key) {
        int position = getPosition(hash(key.hashCode()));
        Node node = hashTable[position];

        if (node != null) {
            while (node.hasNext()) {
                if (node.key.equals(key)) {
                    return true;
                }

                node = node.next;
            }

            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (Node node : hashTable) {

            while (node.hasNext()) {
                if (node.value.equals(value)) {
                    return true;
                }

                node = node.next;
            }

            if (node.value.equals(value)) {
                return true;
            }
        }

        return false;
    }


    private void ensureCapacity(int newCapacity) {
        if (hashTable.length * 0.75 < newCapacity) {
            Node<K, V>[] oldTable = hashTable;
            this.hashTable = new Node[hashTable.length * 2];
            for (Node node : oldTable) {
                putNode(node);
            }
        }
    }

    private int getPosition(int hash) {
        ensureCapacity(size + 1);
        return hash % hashTable.length;
    }


    public synchronized int size() {
        return this.size;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized void clear() {
        hashTable = new Node[16];
        size = 0;
    }


    int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
