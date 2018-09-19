package cn.a2vk.algorithm.graph;

import java.io.*;

/**
 * Created by hoducust on 2018/9/18 22H 11m .
 * <p>
 * 加载文件中的 图信息生成图对象
 */
public class ReadGraph {

//    public ReadGraph(Graph graph, String path) {
//
//    }

    public Graph load(Graph graph, String path) throws IllegalAccessException {

        Iterable<String> lines = readFile(path);
        int n = 0;
        for (String str : lines) {
            String[] line = str.trim().split(" ");
            int v = Integer.getInteger(line[0]);
            int w = Integer.getInteger(line[1]);
            if (n != 0) {
                if (v >= 0 && v < graph.V() && w >= 0 && w < graph.V()) {
                    graph.addEdge(v, w);
                } else {
                    throw new IllegalAccessError("out of size !");
                }
            }else {
                if(graph.V() == v)
                    throw new IllegalAccessException("out of size !");
            }
            n++;
        }
        return graph;
    }

    private Iterable<String> readFile(String path) {
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Iterable<String> iter = (Iterable) bfr.lines().iterator();
        return iter;
    }

}
