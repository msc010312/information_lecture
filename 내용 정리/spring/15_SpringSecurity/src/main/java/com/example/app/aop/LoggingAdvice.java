package com.example.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {
	
	@Before("execution(boolean com.example.app.domain.service.MemoServiceImpl.registrationMemo(..))")
	public void logginBefore(JoinPoint joinPoint) {
		log.info("aop before : " + joinPoint);
	}
	
	@After("execution(* com.example.app.domain.service.MemoServiceImpl.getAllMemo)")
	public void logginAfter(JoinPoint joinPoint) {
		log.info("aop before : " + joinPoint);
		log.info("aop before : " + joinPoint.getTarget());
		log.info("aop before : " + joinPoint.getSignature());
		log.info("aop before : " + joinPoint.getSignature().getName());
	}
	
	@Around("excution(* com.example.app.domain.service.*.*(..))")
	public Object loggingAround(ProceedingJoinPoint pjp) throws Throwable {
		// 이전시점
		log.info("aop around before");
		long startTime = System.currentTimeMillis();
		// MVC흐름대로 진행
		Object isUpdated = (Object)pjp.proceed();
		// 이후 시점
		log.info("aop around after");
		long endTime = System.currentTimeMillis();
		log.info("aop time : " + (endTime-startTime) + "ms");
		
		return isUpdated;
	}
}
