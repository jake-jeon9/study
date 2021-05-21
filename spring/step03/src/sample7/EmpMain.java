package sample7;

import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample7/bean.xml");
		
		Emp person1 =(Emp) context.getBean("developer");
		Emp person2 =(Emp) context.getBean("engineer");
		
		System.out.println(person1.toString());
		System.out.println(person2.toString());
		
		context.close();
	}
}
