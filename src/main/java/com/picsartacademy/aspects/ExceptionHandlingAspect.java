package com.picsartacademy.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {


       private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.picsartacademy..*.*(..))", throwing = "ex")
    public void handleException(Exception ex) {
        logger.error("Exception occurred: {}", ex.getMessage());
    }

}

