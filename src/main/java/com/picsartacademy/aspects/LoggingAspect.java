package com.picsartacademy.aspects;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.picsartacademy.controller.*.*(..))")
    public Object logRequestProcessingTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        String methodName = joinPoint.getSignature().getName();
        String requestURI = getRequestURI(joinPoint);
        String parameters = Arrays.toString(joinPoint.getArgs());
        long processingTime = endTime - startTime;

        logger.info("Request URI: {}, Method: {}, Parameters: {}, Processing Time: {} ms",
                requestURI, methodName, parameters, processingTime);

        return result;
    }

    private String getRequestURI(ProceedingJoinPoint joinPoint) {
        return Arrays.stream(joinPoint.getArgs())
                .filter(arg -> arg instanceof HttpServletRequest)
                .map(arg -> ((HttpServletRequest) arg).getRequestURI())
                .findFirst()
                .orElse("Unknown URI");
    }
}

