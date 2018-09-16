package cn.a2vk.algorithm.unionfind;

/**
 * Created by hoducust on 2018/9/16 14H 12m .
 */
public class UnionFindV2 {

    private int[] arr;
    private int count;
    private int[] parent;

    public UnionFindV2(int arrLen) {
        arr = new int[arrLen];
        parent = new int[arrLen];

        this.count = arrLen;
        for (int i = 0; i < arrLen; i++) {
            arr[i] = i;
            parent[i] = i;
        }
    }

    // 查找 元素根节点
    public int find(int id) {
        if (0 <= id && id < count) {
            while (id != parent[id]) {
                id = parent[id];
            }
            return id;
        } else {
            throw new IndexOutOfBoundsException("...");
        }
    }

    //比较根元素是否相同
    public boolean isConnection(int p, int q) {
        return find(p) == find(q);
    }

    // 比较根元素是否同根元素，不同合并根O(1)
    public void toUnion(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
    }


}
