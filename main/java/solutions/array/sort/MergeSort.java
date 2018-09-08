package solutions.array.sort;

import solutions.utility.ArrayListEngine;

import java.util.Arrays;

/**
 * Created by hoducust on 2018/8/12 22H 52m .
 * <p>
 * 主要思想：二分法 将数组无限划分为最小单位， 再通过 有序最小单位 合并产生 有序最小单位，直至整个数组完全有序（自身成为有序最小单位）
 * <p>
 * 要点：分治法的 最小单位 分界点，
 */
public class MergeSort {

    private void merge(int[] arr, int l, int mid, int r) {


        int[] aux = Arrays.copyOfRange(arr, l, r + 1);


        // 将数组 从左到右进行merge
        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {

            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }

        }

    }

    private void sort(int[] arr, int l, int r) {

        if (l >= r) return;

        int mid = (l + r) / 2;

        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);

    }

    public int[] solution1(int[] arr) {

        int len = arr.length;
        sort(arr, 0, len - 1);
        return arr;
    }

    public static void main(String[] args) {
        int[] list = new ArrayListEngine().randomGenerateArray(9999, 1000000, 1423L);
        new MergeSort().solution1(list);

    }
}
