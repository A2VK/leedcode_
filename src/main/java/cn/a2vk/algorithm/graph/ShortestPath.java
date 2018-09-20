package cn.a2vk.algorithm.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by hoducust on 2018/9/19 22H 58m .
 */
public class ShortestPath {

    private Graph graph;
    private int s;
    private boolean[] visited;
    private int[] from;
    private int[] ord;


    public ShortestPath(Graph vgraph, int s) {
        this.graph = vgraph;
        if (s >= 0 && s < graph.V()) {
            visited = new boolean[graph.V()];
            from = new int[graph.V()];
            ord = new int[graph.V()];

            for (int i = 0; i < graph.V(); i++) {
                from[i] = -1;
                ord[i] = -1;
            }
            this.s = s;
            // BFS
            Deque<Integer> stage = new ArrayDeque<>();
            stage.push(s);
            visited[s] = true;

            while (!stage.isEmpty()) {
                int v = stage.poll();
                for (int i : graph.adj(v)) {
                    stage.add(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
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
