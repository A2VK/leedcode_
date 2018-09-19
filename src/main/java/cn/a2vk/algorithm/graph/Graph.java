package cn.a2vk.algorithm.graph;

/**
 * Created by hoducust on 2018/9/18 21H 52m .
 */
public interface Graph {

    int V();

    int E();

    void addEdge(int v, int w);

    boolean hasEdge(int v, int w);



    public Iterable<Integer> adj(int v);

    void show();

}
