package com.yuan.threadlocal;

import com.yuan.domain.Node;

import java.util.Stack;

/**
 * @Author: yuanjz
 * @Date: 2021-08-30 11:18
 * @Description:
 */
public class NodeStack {

    private static ThreadLocal<Stack<Node>> nodeStackLocal = new ThreadLocal<>();

    public static void push(Node node) {
        Stack<Node> stack = nodeStackLocal.get();
        if (stack == null) {
            stack = new Stack<>();
        }
        stack.push(node);
        nodeStackLocal.set(stack);
    }

    public static Node peek() {
        Stack<Node> stack = nodeStackLocal.get();
        if (stack == null) {
            return null;
        }
        return stack.peek();
    }

    public static void pop() {
        Stack<Node> stack = nodeStackLocal.get();
        if (stack == null || stack.empty()) {
            return;
        }
        stack.pop();
        if (stack.empty()) {
            nodeStackLocal.remove();
        }
    }

}
