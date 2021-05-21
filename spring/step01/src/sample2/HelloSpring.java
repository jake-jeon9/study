package sample2;

public class HelloSpring {
	public static void main(String[] args) {
		//다형성을 이용해서 결합도(=의존성이)를 낮춘 프로그램
		//상속된 클래스의 부모기준 사용법
		//전제조건 : 사용하려고 하는 자식 클래스의 함수가 반드시 부모에게 존재해야 함.
		/*
		MessageBean bean = new MessageBeanKr();
		bean.sayHello();
		*/
		MessageBean bean = new MessageBeanEn();
		bean.sayHello();
		
		
	}

}
