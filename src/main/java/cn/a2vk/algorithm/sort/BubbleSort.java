package cn.a2vk.algorithm.sort;

import cn.a2vk.utility.ArrayListEngine;

/**
 * Created by hoducust on 2018/8/12 22H 51m .
 *
 * 算法优点：实现简单，小数据量下
 * 算法缺点：算法复杂度O^2 过高的复杂度
 */
public class BubbleSort {


    public int[] solution1(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {

            for (int j = 0; j < i; j++) {
                int curr = arr[j];
                int next = arr[j + 1];
                if (curr > next) {
                    arr[j] = next;
                    arr[j + 1] = curr;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] list = new ArrayListEngine().randomGenerateArray(9999, 1000000, 1423L);
        new BubbleSort().solution1(list);
    }
}
