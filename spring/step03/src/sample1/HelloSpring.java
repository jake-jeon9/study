package sample1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		//1. bean.xml 설정 정보를 이용해서 bean 객체 생성
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample1/bean.xml");
		
		//2. bean 객체 얻기
		MessageBean bean =(MessageBean)context.getBean("messageBean");
		bean.sayHello();
		bean.sayHello("banana", 5000);
		//3. 스프링 컨테이너 종료
		context.close();
		
	}
}
