package com.yuan.config;

import com.yuan.aop.SpiderInterceptor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yuanjz
 * @Date: 2021-08-27 18:05
 * @Description:
 */
@ComponentScan("com.yuan")
@Configuration
public class InterceptorConfig {

    @Value("${spider.expression:execution(* com.y..*.*(..))}")
    private String expression;

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setAdvice(new SpiderInterceptor());
        advisor.setPointcut(pointcut);
        return advisor;
    }
}
