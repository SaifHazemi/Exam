package tn.inetum.blm.example.exam.Aspects;


import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.LogManager;
import java.util.logging.Logger;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.inetum.blm.example.exam.Service.*.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @After("execution(* tn.inetum.blm.example.exam.Service.*.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out method " + name + " : ");
    }
}
