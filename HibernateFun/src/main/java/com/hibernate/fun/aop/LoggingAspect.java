package com.hibernate.fun.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Hosh on 2017-04-30.
 */

@Component
@Aspect
public class LoggingAspect
{
    private static final Logger logger = Logger.getLogger(LoggingAspect.class);
    private final String LOG_FORMAT="Declare type: %s, Method name: %s, Arguments: %s, Target class: %s";

    @Around("execution(* *.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable
    {
        try {
            long start = System.nanoTime();
            Object result = joinPoint.proceed();
            logger.trace(String.format(LOG_FORMAT + ", Last %s [ms]",
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(),
                    Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getTarget().getClass().getName(),
                    (System.nanoTime()-start)/1000000));
            return result;
        } catch (IllegalArgumentException e) {
            logger.error("Illegal argument "
                    + Arrays.toString(joinPoint.getArgs()) + " in "
                    + joinPoint.getSignature().getName() + "()");
            throw e;
        }
    }
}