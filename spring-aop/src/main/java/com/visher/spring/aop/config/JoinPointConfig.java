package com.visher.spring.aop.config;

import org.aspectj.lang.annotation.Pointcut;

public class JoinPointConfig {
//
//    @Pointcut("execution(* io.datajek.springaop.movierecommenderaop.data.*.*(..))")
//    public void dataLayerPointcut() {
//    }

    @Pointcut("execution(* com.visher.spring.aop.movierecommenderaop.business.*.*(..))")
    public void businessLayerPointcut() {
    }

    //to intercept method calls for both layers:
//    @Pointcut("io.datajek.springaop.movierecommenderaop.aspect.JoinPointConfig.dataLayerPointcut() || "
//            + "io.datajek.springaop.movierecommenderaop.aspect.JoinPointConfig.businessLayerPointcut()")
//    public void allLayersPointcut() {
//    }


    @Pointcut("@annotation(com.visher.spring.aop.annotation.MeasureTime)")
    public void measureExecutionTime() {
    }

    //for a particular bean
    @Pointcut("bean(movie*)")
    public void movieBeanPointcut() {
    }
}