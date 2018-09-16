package cn.a2vk.algorithm.unionfind;

/**
 * Created by hoducust on 2018/9/16 14H 12m .
 */
public class UnionFindV3 {

    private int count;
    private int[] parent;
    private int[] rSize;

    public UnionFindV3(int arrLen) {
        parent = new int[arrLen];
        rSize = new int[arrLen];

        this.count = arrLen;
        for (int i = 0; i < arrLen; i++) {
            parent[i] = i;
            rSize[i] = 1;
        }
    }

    // 查找 元素根节点
    public int find(int id) {
        if (0 <= id && id < count) {
            while (id != parent[id])
                id = parent[id];
            return id;
        } else {
            throw new IndexOutOfBoundsException("...");
        }
    }

    //比较根元素是否相同
    public boolean isConnection(int p, int q) {
        return find(p) == find(q);
    }

    // 比较根元素是否同根元素，不同合并根O(1), 均衡节点数， 避免find耗时
    public void toUnion(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;
        if (rSize[p] < rSize[1]) {
            rSize[p] += rSize[q];
            parent[rootP] = rootQ;
        } else {
            rSize[q] += rSize[p];
            parent[rootQ] = rootP;
        }
    }


}
