package cn.a2vk.algorithm.unionfind;

/**
 * Created by hoducust on 2018/9/15 22H 02m .
 */
public class UnionFindV1 {

    private int[] arr;
    private int count;

    public UnionFindV1(int n) {
        arr = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    public int find(int p) {
        if (p < arr.length) {
            return arr[p];
        } else {
            throw new IndexOutOfBoundsException("...");
        }
    }

    public boolean isConnection(int p, int q) {
        return find(p) == find(q);
    }

    public void toUnion(int p, int q) {
        int idP = arr[p];
        int idQ = arr[q];

        if (idP == idQ) return;

        for (int i = 0; i < count; i++) {
            if (arr[i] == idP) {
                arr[i] = idQ;
            }
        }
    }

    public int size() {
        return count;
    }

}
