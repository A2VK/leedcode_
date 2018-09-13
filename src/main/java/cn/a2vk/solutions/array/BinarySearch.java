package cn.a2vk.solutions.array;

/**
 * Created by hoducust on 2018/9/13 21H 23m .
 */
public class BinarySearch<T extends Comparable> {

    public int basicBS(T[] sets, T target) {

        int l = 0, r = sets.length - 1;


        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (sets[mid] == target) {
                return mid;
            }

            if (sets[mid].compareTo(target) > 0) {
                r = mid - 1; //note: mid 位置在二分查找中的变动

            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
