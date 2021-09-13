package com.yuan.threadlocal;

import com.yuan.domain.Graph;

import java.util.UUID;

/**
 * @Author: yuanjz
 * @Date: 2021-08-30 17:22
 * @Description:
 */
public class LocalGraph {

    private static ThreadLocal<Graph> graphThreadLocal = new ThreadLocal<>();

    public static Graph get() {
        Graph graph = graphThreadLocal.get();
        if (graph == null) {
            graph = new Graph();
            graph.setGraphId(UUID.randomUUID().toString());
            graphThreadLocal.set(graph);
        }
        return graph;
    }

    public static void clear() {
        graphThreadLocal.remove();
    }
}
