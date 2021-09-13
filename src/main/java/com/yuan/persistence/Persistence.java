package com.yuan.persistence;

import com.yuan.domain.Graph;
import com.yuan.domain.Node;

import java.util.List;
import java.util.Map;

/**
 * @Author: yuanjz
 * @Date: 2021-08-31 15:25
 * @Description:
 */
public interface Persistence {

    boolean saveGraph(Graph graph);

    Map<String, List<Graph>> allController();

    List<Node> getChildren(String graphId, String nodeId);

}
