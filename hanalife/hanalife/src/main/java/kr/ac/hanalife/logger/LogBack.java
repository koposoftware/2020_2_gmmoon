package kr.ac.hanalife.logger;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogBack {
	
	private static final Logger log = LoggerFactory.getLogger(LogBack.class);
	
	 public void infoLog(String category, String message) {
	      log.info("[ " + category + " ] " + message);
	 }
	 
	 @Before("execution(* kr.ac.hanalife.member.service.MemberService*.*(..))")
	 public void logBefore(JoinPoint joinPoint) {
		 
		 String signatureString = joinPoint.getSignature().getName();
		 
		 log.info("==============================");
		 log.info("logBefore");
		 log.info(signatureString + "메서드 실행 전처리 수행");
		 
		 for(Object arg : joinPoint.getArgs()) {
			 log.info("[" + signatureString + "] 아규먼트" + arg);
		 }
		 
		 log.info("==============================");
	 }
	 
	 @AfterThrowing(pointcut = "execution(* kr.ac.hanalife.member.service.MemberService*.*(..))" ,throwing="exception")
	 public void logException(Exception exception) {
		 log.info("예외발생..!!!");
		 log.info("exception : ", exception);
	 }
	 
	 //Target을 정해준다
	 @Around("execution(* kr.ac.hanalife.member.service.MemberService*.*(..))")
	 public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		 
		 long start = System.currentTimeMillis();
		 
		 log.info("Target : " + pjp.getTarget());
		 log.info("Param : " + Arrays.toString(pjp.getArgs()));
		 
		 //invoke method
		 Object result = null;
		 
		 try {
			result = pjp.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 long end = System.currentTimeMillis();
		 log.info("Time : " + (end - start));
		 
		//Around를 사용할 경우 반드시 Object를 리턴해야 한다.
		 return result;
	 }
	 
	
}
