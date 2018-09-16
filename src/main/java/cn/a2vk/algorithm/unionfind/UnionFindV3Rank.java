package cn.a2vk.algorithm.unionfind;

/**
 * Created by hoducust on 2018/9/16 14H 12m .
 */
public class UnionFindV3Rank {

    private int count;
    private int[] parent;
    private int[] rank;

    public UnionFindV3Rank(int arrLen) {
        parent = new int[arrLen];
        rank = new int[arrLen];

        this.count = arrLen;
        for (int i = 0; i < arrLen; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int size() {
        return count;
    }

    // 查找 元素根节点 -> 优化find 查找父节点时间
    public int find(int point) {
        if (0 <= point && point < count) {
//            while (point != parent[point])
//                // compression path (use 2 step find root )
//                parent[point] = parent[parent[point]];
//                point = parent[point];
//            return point;

            if (parent[point] != point)
                parent[point] = find(parent[point]);
            return parent[point];
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
        if (rank[p] < rank[q]) {
            parent[rootP] = rootQ;
        } else if (rank[q] < rank[p]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootP] = rootQ;
            rank[rootP] += 1;
        }
    }


}
