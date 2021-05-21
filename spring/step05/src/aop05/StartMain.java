package aop05;

import org.springframework.context.support.GenericXmlApplicationContext;

public class StartMain {
	public static void main(String[] args) {
	//1. 스프링 컨테이너 구동	
	GenericXmlApplicationContext context = new GenericXmlApplicationContext("aop05/bean.xml");
	
	//2. bean 객체 얻기
	Person person = (Person) context.getBean("woman");
	/*
	 * person.classwork()를 호출시키면, 스프링 컨테이너가 이 함수를 가로채서 MyAspect 클래스의 invoke() 메소드로 전달함.
	 */
	person.classwork();
	
	//3. 스프링 컨테이너 종료
	context.close();
	}
}
