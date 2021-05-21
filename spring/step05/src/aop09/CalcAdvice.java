package aop09;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CalcAdvice {
	
	@Before("execution(public * *(..))")
	public void before() {
		System.out.println("연산을 시작합니다..");
	}
	
	@After("execution(public * *(..))")
	public void after() {
		System.out.println("연산을 종료합니다.");
		
	}
	
}
