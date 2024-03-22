package com.picsartacademy.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class MethodExecutionTimeAspect {

    @Around("execution(* com.picsartacademy.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        Logger.getLogger(String.valueOf(joinPoint.getTarget().getClass())).info(
                joinPoint.getSignature() + " executed in " + executionTime + "ms"
        );
        return proceed;
    }
}
