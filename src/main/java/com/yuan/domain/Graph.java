package com.yuan.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yuanjz
 * @Date: 2021-08-30 16:39
 * @Description:
 */
@Data
public class Graph {

    private String graphId;

    private Map<String, Node> nodeMap = new HashMap<>();

    private Map<String, Line> lineMap = new HashMap<>();

    public void addLine(Node sourceNode, Node targetNode) {
        nodeMap.put(sourceNode.getNodeId(), sourceNode);
        nodeMap.put(targetNode.getNodeId(), targetNode);
        Line line = new Line(sourceNode.getNodeId(), targetNode.getNodeId());
        lineMap.put(line.getLineId(), line);
    }
}
