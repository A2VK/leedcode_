package cn.a2vk.algorithm.graph;

import java.rmi.AccessException;

/**
 * Created by hoducust on 2018/9/19 21H 48m .
 */
public class Components {

    private Graph graph;
    private boolean[] visited;
    private int ccount;
    private int[] id;


    public Components(Graph vgraph) {
        this.graph = vgraph;
        visited = new boolean[graph.V()];
        id = new int[vgraph.V()];

        for (int i = 0; i < graph.V(); i++) {
            id[i] = -1;
        }

        for (int i = 0; i < graph.V(); i++) {

            if (!visited[i]) {// 没有被访问过
                DFS(i);
                ccount++;
            }
        }

    }

    private void DFS(int v) {
        visited[v] = true; //已访问节点标记
        id[v] = ccount; //标记当前点有多少连通分量(图存在多少不连通孤立点)
        //遍历途中的点
        for (int i : graph.adj(v)) {
            if (!visited[i]) DFS(i);// 没被访问过 深度遍历点
        }
    }

    public boolean isConnected(int v, int w) throws IllegalAccessException {
        if (v >= 0 && v < graph.V() && w >= 0 && w < graph.V()) {
            return id[v] == id[w];
        }else {
            throw new IllegalAccessException("v or w error");
        }
    }

    public int count() {
        return ccount;
    }
}
