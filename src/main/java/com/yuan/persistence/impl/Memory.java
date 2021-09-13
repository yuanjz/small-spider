package com.yuan.persistence.impl;

import com.yuan.domain.Graph;
import com.yuan.domain.Line;
import com.yuan.domain.Node;
import com.yuan.persistence.Persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: yuanjz
 * @Date: 2021-08-31 16:06
 * @Description:
 */
public class Memory implements Persistence {

    private static Map<String, Graph> graphMap = new HashMap<>();

    @Override
    public boolean saveGraph(Graph graph) {
        graphMap.put(graph.getGraphId(), graph);
        return true;
    }

    @Override
    public Map<String, List<Graph>> allController() {
        return graphMap.values().stream().collect(Collectors.groupingBy(this::getControllerNodeId));
    }

    @Override
    public List<Node> getChildren(String graphId, String nodeId) {
        Graph graph = graphMap.get(graphId);
        List<String> childrenNodeIdList = graph.getLineMap().values()
                .stream()
                .filter(line -> line.getSourceNodeId().equals(nodeId))
                .map(Line::getTargetNodeId)
                .collect(Collectors.toList());
        return graph.getNodeMap().values()
                .stream()
                .filter(node -> childrenNodeIdList.contains(node.getNodeId()))
                .collect(Collectors.toList());
    }

    private String getControllerNodeId(Graph graph) {
        return graph.getLineMap().values().stream()
                .filter(line -> "/".equals(line.getSourceNodeId()))
                .findFirst()
                .orElse(new Line())
                .getTargetNodeId();
    }
}
