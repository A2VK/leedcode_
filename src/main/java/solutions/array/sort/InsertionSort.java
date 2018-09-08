package solutions.array.sort;

import solutions.utility.ArrayListEngine;

/**
 * Created by hoducust on 2018/8/12 22H 51m .
 *
 * 原理：将未排序的值  插入到已排序的正确位置中；
 *
 * 优点：在近乎有序的情况下效率高
 *
 * 缺点：在近乎无序的 情况下 交换次数过多，性能下降剧烈，但是一个稳定排序算法；
 *
 */
public class InsertionSort {

    public int[] solution1(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            // int hold = arr[i];
            for (int j = i; j > 0; j--) {
                int curr = arr[j];
                if (arr[j - 1] > curr) {
                    arr[j] = arr[j - 1];
                    arr[j - 1] = curr;
                }
                // break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] list = new ArrayListEngine().randomGenerateArray(9999, 1000000, 1423L);
        new InsertionSort().solution1(list);
    }

}
