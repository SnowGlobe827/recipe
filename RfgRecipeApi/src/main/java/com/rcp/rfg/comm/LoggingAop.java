package com.rcp.rfg.comm;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Aspect: 이 클래스가 AOP 기능을 수행하는 Aspect임을 나타냄
@Aspect
@Component
public class LoggingAop {
	
	@Pointcut(value = "execution(public * com.rcp.rfg.jpa.service.*Service*.*(..))")
	public void pointCut() {}
	
	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		log.info("[AOP Logging]Start Method: {}", joinPoint.getSignature().getName());
		
		Object[] obj = joinPoint.getArgs();
		if(obj != null) {
			log.info("[AOP Logging] Arguments: {}", Arrays.toString(obj));
		}
	}
	
	@AfterReturning(pointcut = "pointCut()", returning = "returnValue")
	public void afterReturning(JoinPoint joinPoint, Object returnValue) {
		log.info("[AOP Logging] ResultValue: {}",returnValue);
	}
	
	@AfterThrowing(pointcut = "pointCut()", throwing = "error")
	public void afterThrowing(JoinPoint joinPoint, Exception error) {
		log.info("[AOP Logging] Exception Method: {}", joinPoint.getSignature().getName());
		log.info("[AOP Logging] Error Message: {}", error.getMessage());
	}
}
