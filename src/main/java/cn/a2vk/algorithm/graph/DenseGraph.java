package cn.a2vk.algorithm.graph;

import java.util.ArrayList;

/**
 * Created by hoducust on 2018/9/17 23H 00m .
 */
public class DenseGraph implements Graph {

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

    public int V() {
        return n;
    }

    public int E() {
        return m;
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

    public ArrayList<Integer> adj(int v) {

        if (v >= 0 && v < n) {
            ArrayList<Integer> adj = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                if (g[v][i]) adj.add(i);
            }
            return adj;
        } else {
            throw new IllegalArgumentException("v error");
        }
    }

    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(g[i][j] + "\t");
            System.out.println();
        }
    }

}
