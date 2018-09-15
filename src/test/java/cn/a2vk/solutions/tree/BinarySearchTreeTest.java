package cn.a2vk.solutions.tree;

import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by hoducust on 2018/9/15 15H 33m .
 */
public class BinarySearchTreeTest {


    private BinarySearchTree bst;
    private List<Integer> arr = Arrays.asList(18, 15, 1, 4, 3, 6, 23, 19,
            7, 5, 12, 17, 10, 16, 9, 14, 20, 22, 25, 11);

    @Before
    public void setUp() throws Exception {
        bst = new BinarySearchTree<Integer, String>();

        for (Integer i : arr) {
            bst.insert(i, String.valueOf(i));
        }
    }

    @Test
    public void size() {
        assertEquals(arr.size(), bst.size());
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void contain() {
    }

    @Test
    public void search() {
    }

    @Test
    public void preOrder() {
    }

    @Test
    public void inOrder() {
    }

    @Test
    public void postOrder() {
    }

    @Test
    public void levelOrder() {
    }

    @Test
    public void minimum() {
    }

    @Test
    public void maxmum() {
    }

    @Test
    public void deleteMinimum() {
    }

    @Test
    public void deleteMaxmum() {
    }

    @Test
    public void delete() {
    }
}