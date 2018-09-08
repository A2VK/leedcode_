package solutions.array.sort;

import solutions.utility.ArrayListEngine;

/**
 * Created by hoducust on 2018/8/12 22H 51m .
 * <p>
 * 选择排序逻辑： 标定当前所在位置， 通过扫描数组中后续的值与当前比较大小，
 * 随之判断是否与当前位置交换，当前位置确保为数组中的当前最大/最小值；
 * 当前值后移，依上判断后续值是否交换，直至完成排序；
 * 算法优点：相较于冒泡排序减少了数据间的多余交换操作；
 * 算法缺点：实际算法复杂度O^2 相较于冒泡排序没有实质性的提高；
 */
public class SelectionSort {

    public int[] solution1(int[] arr) {

        if (arr == null || arr.length < 1) {
            return arr;
        }

        int min = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                int curr = arr[j];

                if (curr < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] list = new ArrayListEngine().randomGenerateArray(9999, 1000000, 1423L);
        new SelectionSort().solution1(list);
    }

}
