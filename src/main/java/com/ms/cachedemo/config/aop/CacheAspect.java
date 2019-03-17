package com.ms.cachedemo.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@Aspect
public class CacheAspect {
    private final ValueOperations<String, Object> operations;

    public CacheAspect(RedisTemplate<String, Object> redisTemplate) {
        this.operations = redisTemplate.opsForValue();
    }

    @Around("@annotation(Cacheable)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        final Object o = this.operations.get("?");
        return isNull(o) ?
                joinPoint.proceed() : o;
    }
}
