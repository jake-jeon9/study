package sample9;

import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample9/bean2.xml");
		
		Developer developer=(Developer) context.getBean("developer");
		Engineer engineer =(Engineer) context.getBean("engineer");
		
		System.out.println(developer.toString());
		System.out.println(engineer.toString());
		
		context.close();
	}
}
