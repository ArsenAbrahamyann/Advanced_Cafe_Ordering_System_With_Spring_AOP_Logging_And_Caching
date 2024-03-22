package com.picsartacademy.aspects;

import com.picsartacademy.cache.SoftReferenceCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Aspect
@Component
public class CacheAspect {

    @Autowired
    private SoftReferenceCache cache;

    @Around("execution(* com.picsartacademy.dao.impl.*.*(..)) || execution(* com.picsartacademy.controller.*.*(..))")
    public Object cacheTimeServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = createCacheKey(joinPoint);
        Optional<Object> optionalValue = cache.get(key);

        if (optionalValue.isPresent()) {
            return optionalValue.get();
        }

        Object result = joinPoint.proceed();
        cache.put(key, result);
        return result;
    }

    public String createCacheKey(ProceedingJoinPoint joinPoint) {
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(joinPoint.getSignature().toShortString());
        keyBuilder.append(Arrays.toString(joinPoint.getArgs()));
        return keyBuilder.toString();
    }
}
