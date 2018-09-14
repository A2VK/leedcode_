package cn.a2vk.solutions.tree;

/**
 * Created by hoducust on 2018/9/13 22H 11m .
 *
 * 树的遍历 >>
 * 先序遍历：先访问自己，再递归访问左右子树
 * 中序遍历：先递归访问左子树，再访问自己，再递归访问右子树
 * 后续遍历：先递归左右子树，最后访问自己
 *
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

    // 先序遍历：先访问自己，再递归访问左右子树
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 中序遍历：先递归访问左子树，再访问自己，再递归访问右子树
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    // 后续遍历：先递归左右子树，最后访问自己
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }
}
