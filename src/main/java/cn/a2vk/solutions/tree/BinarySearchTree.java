package cn.a2vk.solutions.tree;

/**
 * Created by hoducust on 2018/9/13 22H 11m .
 */
public class BinarySearchTree<K extends Comparable, V> {

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
        insert(root, key, value);
    }

    private Node insert(Node node, K key, V value) {

        if (node.key == null) {
            count++;
            return new Node(key, value);
        }

        if (node.key == key) {
            node.value = value;
        } else if (node.key.compareTo(key) < 0) {
            node.right = insert(node.left, key, value);
        } else {
            node.left = insert(node.right, key, value);
        }
        return node;
    }

    public boolean contain(K key) {
        return contain(root, key);
    }

    private boolean contain(Node node, K key) {

        if (node == null) return false;

        if (node.key == key) {
            return true;
        } else if (node.key.compareTo(key) < 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }

    public V search(K key) {
        return search(root, key);
    }

    private V search(Node node, K key) {

        if (node == null) return null;

        if (node.key == key) {
            return node.value;
        } else if (node.key.compareTo(key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }
}
