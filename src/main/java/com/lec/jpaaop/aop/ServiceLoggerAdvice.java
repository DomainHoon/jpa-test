package com.lec.jpaaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLoggerAdvice {
	private static final Logger logger = LoggerFactory.getLogger(ServiceLoggerAdvice.class);
	
	@Before("execution(* com.lec.jpaaop.controller.BoardController*.*(..))")
	public void startLog(JoinPoint jp) {
		//logger.info("Aop StartLog");
		logger.info("Aop StartLog : =====================  " + jp.getSignature().getName());
		//logger.info("Aop StartLog : " + Arrays.toString(jp.getArgs()));
	}

	@After("execution(* com.lec.jpaaop.controller.BoardController*.*(..))")
	public void logReturning(JoinPoint jp) {
		logger.info("Aop logReturning : =====================  " + jp.getSignature().getName());
	}
	
	@AfterThrowing(pointcut="execution(* ccom.lec.jpaaop.controller.BoardController*.*(..))", throwing="e")
	public void logException(JoinPoint jp, Exception e) {
		logger.info("Aop logExcepiton : =====================  " + jp.getSignature().getName());
		logger.info("Aop logExcepiton : " + e);
	}
	
	@Around("execution(* com.lec.jpaaop.controller.BoardController*.*(..))")
    public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = pjp.proceed();
		long endTime = System.currentTimeMillis();
		logger.info( pjp.getSignature().getName() +":" +(endTime - startTime) );
		return result;
	}
	
	
}
