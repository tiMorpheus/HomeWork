package timur.rbtree;

public class MyRBTree<K extends Comparable, V> {

    private final boolean RED = true;
    private final boolean BLACK = false;

    private Node root;


    private class Node{
        private K key;
        private V value;
        private Node left;
        private Node right;
        private boolean color;
        private int size;

        public Node(K key, V value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }

    public MyRBTree() {
    }


}
