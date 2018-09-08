package sort;

public class Solution {

    public int[] bubbleSort(int[] nums) {

        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    n++;
                }
            }
        }
        System.out.println(n);
        return nums;
    }

    public int[] bubbleSort2(int[] a) {
        int temp;
        int e = 0;
        for (int i = 0; i < a.length - 1; ++i) {
            for (int j = a.length - 1; j > i; --j) {
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    e++;
                }
            }
        }
        System.out.println(e);
        return a;
    }


    public static void main(String[] args) {

        new Solution().bubbleSort(new int[]{0, 1, 6, 9, 24, 6, 8, 2, 4, 3, 3, 6});
        new Solution().bubbleSort2(new int[]{0, 1, 6, 9, 24, 6, 8, 2, 4, 3, 3, 6});
        System.out.println();

    }

}
