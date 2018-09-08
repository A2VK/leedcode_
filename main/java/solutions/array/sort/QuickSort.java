package solutions.array.sort;

import solutions.utility.ArrayListEngine;

import java.util.Random;

/**
 * Created by hoducust on 2018/8/12 22H 52m .
 *
 * 快速排序： 通过标定点，将待排序数组进行分区操作；
 *          （通过标定点将待排序数组分为 小于标定点/大于标定段，）
 *
 */
public class QuickSort {

    private int partition(int[] arr, int l, int r) {
        // 优化 将标定点随机化，避免近乎有序待排序素组 将算法退化为 O^2
        int vi = (int) (Math.random() * (r - l + 1) + l);
        swap(arr, l, vi);

        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) { // 大分区起始点 从标定点下一个开始
            if (arr[i] < v) {
                // 将小于标定点的 数据移动到小数分区中 （注意，小分区从标定点下一个开始）
                swap(arr, ++j, i);
            }
        }
        // 分区完成 将标定点移动到 小分区尾端
        swap(arr, l, j);
        return j;
    }

    private int partition2(int[] arr, int l, int r) {
        int vi = (int) (Math.random() * (r - l + 1) + l);
        int v = arr[l];
        int i = l + 1, j = r;

        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j >= l && arr[j] > v) j--;
            if (i >= j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void sort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);

    }

    private void sort2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition2(arr, l, r);
        sort2(arr, l, p - 1);
        sort2(arr, p + 1, r);
    }

    private void sort2Ways(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int lt = l, gt = r + 1, i = l+1;
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        int v = arr[l];

        while (i < gt) {
            if (arr[i] < v) {
                swap(arr, i++, ++lt);
            } else if (arr[i] > v) {
                swap(arr, i, --gt);
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        sort2Ways(arr, l, lt - 1);
        sort2Ways(arr, gt, r);
    }


    public int[] solution1(int[] arr) {
        int len = arr.length;
        sort(arr, 0, len - 1);
        return arr;
    }

    public int[] solution2(int[] arr) {
        int len = arr.length;
        sort2(arr, 0, len - 1);
        return arr;
    }

    // 3 ways
    public int[] solution3(int[] arr) {
        int len = arr.length;
        sort2Ways(arr, 0, len - 1);
        return arr;
    }

    public static void main(String[] args) {
        int[] list = new ArrayListEngine().randomGenerateArray(9999, 1000000, 1423L);
        new QuickSort().solution3(list);
    }
}
