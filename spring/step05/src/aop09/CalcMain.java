package aop09;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CalcMain {
	public static void main(String[] args) {
		
		//1.스프링 컨테이너 구동
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("aop09/bean.xml");
		
		//2.동작
		CalcMethod calc = (CalcMethod) context.getBean("calc");
		calc.sum(5, 7);
		calc.div(25, 5);
		calc.div(25, 0);
		
		
		//3.스프링 컨테이너 종료
		context.close();
		
	}
}
