package aop03;

import org.aspectj.lang.JoinPoint;

//공통 관심 사항을 모아논 클래스
public class MyAspect{
	// JoinPoint : 핵심 관심사항들을 모아놓은 것.
	public void before(JoinPoint joinPoint) {
		System.out.println("교실문을 연다");
	}
	
	
	
	public void after(JoinPoint joinPoint) {
		System.out.println("교실문을 닫는다.");
		
	}
	
}
