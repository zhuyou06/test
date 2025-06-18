package com.cubc.aop.poincut;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutDefinition {
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void webLayer() {}
}
