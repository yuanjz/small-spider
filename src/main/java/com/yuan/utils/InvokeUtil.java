package com.yuan.utils;

import com.yuan.domain.Node;
import com.yuan.threadlocal.NodeStack;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

/**
 * @Author: yuanjz
 * @Date: 2021-08-30 11:09
 * @Description:
 */
public class InvokeUtil {

    public static Node getCurrent(MethodInvocation invocation) {
        Node node = new Node();
        node.setNodeId(invocation.getMethod().getDeclaringClass().getName() + "#" + invocation.getMethod().getName());
        node.setClassName(invocation.getMethod().getDeclaringClass().getName());
        node.setMethodName(invocation.getMethod().getName());
        node.setParams(Arrays.asList(invocation.getArguments()));
        return node;
    }

    public static Node getParent() {
        Node node = NodeStack.peek();
        if (node == null) {
            node = new Node();
            node.setNodeId("/");
            node.setRootNode(true);
        }
        return node;
    }
}
