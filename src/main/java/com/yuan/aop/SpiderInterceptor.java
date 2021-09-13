package com.yuan.aop;

import com.yuan.domain.Graph;
import com.yuan.domain.Node;
import com.yuan.threadlocal.LocalGraph;
import com.yuan.threadlocal.NodeStack;
import com.yuan.utils.ConfigUtil;
import com.yuan.utils.InvokeUtil;
import com.yuan.utils.PersistenceUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.math.BigDecimal;

/**
 * @Author: yuanjz
 * @Date: 2021-08-27 17:58
 * @Description:
 */
public class SpiderInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Boolean spiderSwitch = ConfigUtil.getSpiderConfig().getSpiderSwitch();
        if (!spiderSwitch) {
            return methodInvocation.proceed();
        }
        Graph graph = LocalGraph.get();
        Node parentNode = InvokeUtil.getParent();
        Node currentNode = InvokeUtil.getCurrent(methodInvocation);
        long beginTime = System.nanoTime();
        currentNode.setBeginTime(beginTime);
        NodeStack.push(currentNode);
        Object returnVal = methodInvocation.proceed();
        currentNode.setReturnVal(returnVal);
        long endTime = System.nanoTime();
        currentNode.setEndTime(endTime);
        currentNode.setResponseTime(new BigDecimal((endTime - beginTime) / 1000000.0).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        graph.addLine(parentNode, currentNode);
        NodeStack.pop();
        if (parentNode.isRootNode()) {
            PersistenceUtil.getInstance().saveGraph(graph);
            LocalGraph.clear();
        }
        return returnVal;
    }
}
