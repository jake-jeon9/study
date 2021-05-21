package sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		//bean객체를 이용해서 결합도(=의존성이)를 낮춘 프로그램

		//1.스프링 컨테이너 구동
		//bean.xml 에 설정한 <bean> 설정 정보를 읽어와 객체를 생성하고 초기화한다.
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample4/bean.xml");
		
		//2. bean 객체 얻어오기
		//bean 객체를 검색하고. bean 객체를 리턴
		//context.getBean("아이디명") ->xml에 설정된 id-""값
		// 이건 오브젝트 타입이라 객체 타입 일치 시켜줘야 함.
		
		MessageBean bean = (MessageBean)context.getBean("messageBean2");
		bean.sayHello();
		
		//3. 스프링 컨테이너 종료
		context.close();
		
	}

}
