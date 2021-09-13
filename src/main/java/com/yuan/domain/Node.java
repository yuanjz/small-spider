package com.yuan.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author: yuanjz
 * @Date: 2021-08-26 10:15
 * @Description:
 */
@Data
public class Node {

    private String nodeId;

    private String className;

    private String methodName;

    private long beginTime;

    private long endTime;

    private Double responseTime;

    private List<Object> params;

    private Object returnVal;

    private boolean rootNode;

}
