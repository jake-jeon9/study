package aop08;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AdviceEx {
	
	@Around("execution(* zeroMethod(..))")
	public void around(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("[around]joinPoint 양쪽의 전에 실행되는 advice");
		jp.proceed();
		System.out.println("[around]joinPoint 양쪽의 후에 실행되는 advice");
	}
	
	@Before("execution(* zeroMethod(..))")
	public void before() {
		System.out.println("[before] joinpoint 앞에서 실행되는 advice");
	}
	
	@After("execution(* zeroMethod(..))")
	public void after() {
		System.out.println(" [after]joinpoint 뒤에서 실행되는 advice");
	}
	
	@AfterThrowing(pointcut="execution(* zeroMethod(..))", throwing = "e")
	public void afterThrowing(Throwable e) {
		System.out.println("[AfterThrowing]예외가 싱핼될 떄 호출되는 advice");
		System.out.println(e.getMessage());
		
	}
	@AfterReturning(pointcut="execution(* zeroMethod(..))",returning = "ret")
	public void afterReturning(Object ret) {
		System.out.println("[afterReturning]joinpoint가 정상 정료후 실행되는 advice");
		
	}
	
}
