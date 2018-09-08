package cn.a2vk.algorithm.sort;

import org.junit.Test;
import cn.a2vk.utility.ArrayListEngine;

import static org.junit.Assert.*;


/**
 * Created by hoducust on 2018/9/8 10H 34m .
 */
public class BubbleSortTest {

    @Test
    public void solution1() {
        ArrayListEngine ale = new ArrayListEngine();
        int[] arr1 = ale.defaultRandomArray();
        int[] arr2 = arr1.clone();

        BubbleSort bs = new BubbleSort();
        QuickSort qs = new QuickSort();
        bs.solution1(arr1);
        qs.solution3(arr2);

        assertArrayEquals(arr1, arr2);

    }
}