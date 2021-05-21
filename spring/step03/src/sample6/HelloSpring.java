package sample6;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample6/bean.xml");
		
		MessageBean message = (MessageBean) context.getBean("messageBean");
		message.helloCall();
		
		context.close();
		
	}
}
