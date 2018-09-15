package cn.a2vk.algorithm.unionfind;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;


/**
 * Created by hoducust on 2018/9/15 22H 52m .
 */
public class UnionFindV1Test {

    UnionFindV1 unf;

    @Before
    public void setUp() throws Exception {
        unf = new UnionFindV1(10000);
    }

    @Test(timeout = 60 * 1000)
    public void find() {
        int count = unf.size();

        for (int i = 0; i < count; i++) {
            int a = (int) (Math.random() * count);
            int b = (int) (Math.random() * count);
            unf.toUnion(a, b);
        }

        for (int i = 0; i < count; i++) {
            int a = (int) (Math.random() * count);
            int b = (int) (Math.random() * count);
            unf.isConnection(a, b);
        }

    }

    @Test
    public void isConnection() {
        UnionFindV1 unf2 = new UnionFindV1(10);
        assertFalse(unf2.isConnection(4, 8));
    }

    @Test
    public void toUnion() {
        UnionFindV1 unf3 = new UnionFindV1(100);
        unf3.toUnion(10, 20);
        assertTrue(unf3.isConnection(10, 20));
    }
}