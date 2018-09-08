package solutions.array.sort;

import solutions.utility.ArrayListEngine;

/**
 * Created by hoducust on 2018/8/12 22H 52m .
 */
public class ShellSort {

    /**
     * 希尔排序： 将数组通过 gap 划分为不同的 小区间 通过将小区间的有序（比较间隔 两端的大小进行交换），逐渐缩小gap的大小 ，将数组排序为有序
     *
     * @param arr
     * @return sorted arr
     */

    private void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public int[] solution1(int[] arr) {

        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    //交换法
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
        return arr;
    }

    public int[] solution3(int[] arr) {

        int len = arr.length, gap = len / 2;
        while (gap > 0) {

            for (int i = gap; i < len; i++) {
                for (int j = i; j - gap > -1 && arr[j] < arr[j - gap]; j -= gap) {
                    int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                }
            }
            gap = gap / 2;
        }
        return arr;
    }

    public int[] solution2(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] list = new ArrayListEngine().randomGenerateArray(100, 10000, 1423L);
        new ShellSort().solution3(list);
    }
}
