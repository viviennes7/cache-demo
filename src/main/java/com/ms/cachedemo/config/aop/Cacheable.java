package com.ms.cachedemo.config.aop;

public @interface Cacheable {
    String value() default "";
}
