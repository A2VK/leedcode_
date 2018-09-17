package cn.a2vk.algorithm.graph;

/**
 * Created by hoducust on 2018/9/17 23H 00m .
 */
public class DenseGraph {

    private int n;
    private int m;
    private boolean directed;
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {

        if (n > 0) {

            this.n = n;
            this.m = 0;
            this.directed = directed;

            g = new boolean[n][n];
        } else {
            throw new IllegalArgumentException("n error!");
        }

    }

    public void addEdge(int v, int w) {
        if (0 <= v && v < n && 0 <= w && v < w) {

            if (hasEdge(v, w)) return;

            g[v][w] = true;
            if (!directed) g[w][v] = true;
            m++;
        }
    }

    public boolean hasEdge(int v, int w) {
        if (0 <= v && v < n && 0 <= w && v < w) {
            if (g[v][w] = true) return true;
        }
        return false;
    }

}
