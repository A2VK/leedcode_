package cn.a2vk.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hoducust on 2018/9/13 22H 11m .
 * <p>
 * 树的遍历 >> 深度优先
 * 先序遍历：先访问自己，再递归访问左右子树
 * 中序遍历：先递归访问左子树，再访问自己，再递归访问右子树
 * 后续遍历：先递归左右子树，最后访问自己
 * <p>
 * 层序遍历 >> 广度优先
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
        root = insert(root, key, value);
    }

    private Node insert(Node node, K key, V value) {

        if (node == null) {
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

    //层序遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node tnode = queue.poll();

            System.out.println(tnode.value);
            ;

            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }

        }
    }

    //最小值
    public V minimum() {
        return minimum(root).value;
    }

    private Node minimum(Node node) {

        if (node == null) return null;

        if (node.left == null) {
            return minimum(node.left);
        } else {
            return node;
        }
    }

    //最大值
    public V maxmum() {
        return maxmum(root).value;
    }

    private Node maxmum(Node node) {
        if (node == null) return null;

        if (node.right != null) {
            return maxmum(node.right);
        } else {
            return node;
        }
    }

    // 删除最小值（找到最小值，无子节点直接删除，有子节点将父节点指向子节点）
    public void deleteMinimum() {
        if (root != null)
            root = deleteMinimum(root);
    }

    private Node deleteMinimum(Node node) {

        if (node.left == null) {
            count--;
            return node.right;
        }
        node.left = deleteMinimum(node.left);
        return node;
    }

    //删除最大值（找到最大值，无子节点直接删除，有子节点将父节点指向子节点）
    public void deleteMaxmum() {
        if (root != null)
            root = deleteMaxmum(root);
    }

    private Node deleteMaxmum(Node node) {

        if (node.right == null) {
            count--;
            return node.left;
        }
        node.right = deleteMaxmum(node.right);
        return node;
    }

    // 删除节点
    public void delete(K key) {
        if (root != null) {
            root = delete(root, key);
        }
    }

    private Node delete(Node node, K key) {

        if (node == null) return null;

        if (node.key.compareTo(key) > 0) {
            node.left = delete(node.left, key);
            return node;
        } else if (node.key.compareTo(key) < 0) {
            node.right = delete(node.right, key);
            return node;
        } else {

            // 单左节点情况
            if (node.left == null) {
                count--;
                return node.right;
            }

            // 单右节点情况
            if (node.right == null) {
                count--;
                return node.left;
            }

            // 双子节点情况
            Node successor = minimum(node.right);
            successor.right = deleteMinimum(node.right);
            successor.left = node.left;
            count--;
            return successor;
        }

    }


}


