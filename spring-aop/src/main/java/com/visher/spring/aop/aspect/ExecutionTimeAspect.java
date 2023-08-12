package com.visher.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ExecutionTimeAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Around("execution(* com.visher.spring.aop.movierecommenderaop.business.*.*(..))")
    @Around("com.visher.spring.aop.config.JoinPointConfig.measureExecutionTime()")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //note start time
        long startTime = System.nanoTime();
        //allow method call to execute
        Object returnValue = joinPoint.proceed();
        //time taken = end time - start time
        long timeTaken = System.nanoTime() - startTime;

        logger.info("Time taken by {} to complete execution is: {}", joinPoint, timeTaken);
        return returnValue;
    }
}