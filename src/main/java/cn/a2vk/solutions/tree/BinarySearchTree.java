package cn.a2vk.solutions.tree;

/**
 * Created by hoducust on 2018/9/13 22H 11m .
 */
public class BinarySearchTree<K, V> {

    private class Node {
        K key;
        V value;

        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.value = null;
        }
    }

    private Node root;
    private int count;

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(K key, V value) {

    }

}
