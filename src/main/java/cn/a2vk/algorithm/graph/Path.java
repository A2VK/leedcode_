package cn.a2vk.algorithm.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by hoducust on 2018/9/19 22H 58m .
 */
public class Path {

    private Graph graph;
    private int s;
    private boolean[] visited;
    private int[] from;


    public Path(Graph vgraph, int s) {
        this.graph = vgraph;
        if (s >= 0 && s < graph.V()) {
            visited = new boolean[graph.V()];
            from = new int[graph.V()];

            for (int i = 0; i < graph.V(); i++) {
                from[i] = -1;
            }
            this.s = s;
            DFS(s);
        }
    }

    private void DFS(int v) {
        if (v >= 0 && v < graph.V())
            for (int i : graph.adj(v)) {
                if (!visited[i]) {
                    from[i] = v;
                    DFS(i);
                }
            }
    }

    public ArrayList<Integer> path(int v) {

        ArrayList<Integer> path = new ArrayList<>(graph.V());

        if (hasPath(v)) {
            for (int i = from.length - 1; i >= 0; i--) {
                path.add(from[i]);
            }
        }
        return path;
    }

    public boolean hasPath(int v) {
        if (v >= 0 && v < graph.V()) {
            return visited[v];
        } else {
            throw new IllegalArgumentException("v error");
        }
    }

    public void showPath(int w) {
        if (hasPath(w)) {
            ArrayList<Integer> path = path(w);
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size()) {
                    System.out.print(" -> ");
                } else {
                    System.out.println();
                }


            }


        }
    }

}
