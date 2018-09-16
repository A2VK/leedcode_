package cn.a2vk.algorithm.unionfind;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by hoducust on 2018/9/16 15H 52m .
 */
public class UnionFindV3RankTest {

    UnionFindV3Rank unf;

    @Before
    public void setUp() throws Exception {
        unf = new UnionFindV3Rank(10000000);
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

}