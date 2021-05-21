package sample5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BirthdayEx {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample5/bean.xml");
		
		DateVo vo1 = (DateVo) context.getBean("hong");
		System.out.println(vo1.toString());
		
		System.out.println("-----------------------");
		DateVo vo2 = (DateVo) context.getBean("kim");
		System.out.println(vo2.toString());
		
		context.close();
		
	}

}
