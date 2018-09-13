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
            node.right = insert(node.right, key, value);
        } else {
            node.left = insert(node.left, key, value);
        }
        return node;
    }

}
