package sample3;

public class HelloSpring {
	public static void main(String[] args) {
		//factory 패턴을 이용해서 결합도(=의존성이)를 낮춘 프로그램
		/*
		BeanFactory factory = new BeanFactory();
		MessageBean bean = factory.getBean("en");
		bean.sayHello();
		*/
		BeanFactory factory = new BeanFactory();
		MessageBean bean = factory.getBean("kr");
		bean.sayHello();
	}

}
