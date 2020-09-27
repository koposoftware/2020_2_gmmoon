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
		 log.info(signatureString + "�޼��� ���� ��ó�� ����");
		 
		 for(Object arg : joinPoint.getArgs()) {
			 log.info("[" + signatureString + "] �ƱԸ�Ʈ" + arg);
		 }
		 
		 log.info("==============================");
	 }
	 
	 @AfterThrowing(pointcut = "execution(* kr.ac.hanalife.member.service.MemberService*.*(..))" ,throwing="exception")
	 public void logException(Exception exception) {
		 log.info("���ܹ߻�..!!!");
		 log.info("exception : ", exception);
	 }
	 
	 //Target�� �����ش�
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
		 
		//Around�� ����� ��� �ݵ�� Object�� �����ؾ� �Ѵ�.
		 return result;
	 }
	 
	
}
