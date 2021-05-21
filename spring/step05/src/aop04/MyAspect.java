package aop04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//공통 관심 사항을 모아논 클래스
//	<bean id="myAdvice" class="aop03.MyAspect"/>
//공통관심사항이라고 알려주는 어노테이션. 
@Aspect
public class MyAspect {
   
   @Before("execution(public void aop04.Woman.classwork())")
   public void before(JoinPoint joinPoint) {
      System.out.println("교실문을 연다.");
   }
   
   @After("execution(public void aop04.Woman.classwork())")
   public void after(JoinPoint joinPoint) {
      System.out.println("교실문을 닫는다.");
   }
   
   @AfterThrowing(pointcut="execution(public void aop04.Woman.classwork())", throwing = "e")
   public void throwing(JoinPoint joinPoint, Throwable e) {
      System.out.println("** 오늘은 소독하는 날 **");
   }
}