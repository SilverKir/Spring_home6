package com.example.sem6home.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
@Component
@Aspect
public class LogginUserActions {
    private Logger logger=Logger.getLogger(LogginUserActions.class.getName());

    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnedValue" )
    public void logResult(JoinPoint joinPoint, Object returnedValue) {
        logger.info("Method "
                + joinPoint.getSignature().getName()
                + " executed and returned " + returnedValue );
    }

}
