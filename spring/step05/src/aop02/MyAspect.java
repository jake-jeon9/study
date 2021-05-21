package aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//AOP를 이용하면, 공통 관심사항 동작을 필요한 함수를 호출할 경우, 
//스프링 컨테이너는 그 함수를 가로채서 invoke 함수를 호출하고
//매개변수로 가로챈 함수가 전달한다.
public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object returnValue=null; //모든 자료형에 대한 리턴값을  저장할 수 있음
		
		//공통 관심사항
		//대상 메소드를 실행전 코드 
		System.out.println("교실문을 연다");
		
		try {
			//핵심 관심사항
			//대상 메소드를 실행
			returnValue=invocation.proceed();
			//여기서 가로채온 함수 실행.
		}catch(Exception e) {
			//공통 관심사항
			//대상 메소드 실행 중 예외가 발생 시 실행되는 코드
			System.out.println("**오늘은 소득하는 날**");
		}finally {
			//공통 관심사항
			//대상 메소드 실행 후
			System.out.println("전들이 켜져 있는지 확인한다.");
		}
		//공통 관심사항
		//대상 메소드 실행 후
		System.out.println("교실문을 잠근다.");
		return returnValue;
	}
}
