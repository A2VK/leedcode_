package cn.a2vk.algorithm.graph;

import java.util.ArrayList;

/**
 * Created by hoducust on 2018/9/17 23H 00m .
 */
public class SparseGraph {

    private int n;
    private int m;
    private boolean directed;

    private ArrayList<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        if (n > 0) {
            this.n = n;
            this.m = 0;
            this.directed = directed;

            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
        } else {
            throw new IllegalArgumentException("n error!");
        }
    }

    public void addEdge(int v, int w) {

        if (0 <= v && v < n && 0 <= w && v < w) {
            g[v].add(w);
            if (v != w && !hasEdge(v, w)) {
                g[w].add(v);
            }
            m++;
        }

    }

    public boolean hasEdge(int v, int w) {
        if (0 <= v && v < n && 0 <= w && v < w) {
            for (int i = 0; i < v; i++) {
                if (g[v].get(i) == w) return true;
            }
        }
        return false;
    }

}
