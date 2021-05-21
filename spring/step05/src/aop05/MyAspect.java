package aop05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//공통 관심 사항을 모아논 클래스
//	<bean id="myAdvice" class="aop03.MyAspect"/> 
@Aspect
public class MyAspect {
	
	//핵심 관심 사항 함수 설정을 분리
	//=>함수 이름만 설정
	@Pointcut("execution(* classwork())")
	public void myClass() {
		
	}
   //  저 함수가 작동되면 아래 비포 에프터가 또 작동함.
	
   @Before("myClass()")
   public void before(JoinPoint joinPoint) {
      System.out.println("교실문을 연다.");
   }
   
   @After("myClass()")
   public void after(JoinPoint joinPoint) {
      System.out.println("교실문을 닫는다.");
   }
   
   @AfterThrowing(pointcut="myClass()", throwing = "e")
   public void throwing(JoinPoint joinPoint, Throwable e) {
      System.out.println("** 오늘은 소독하는 날 **");
   }
}