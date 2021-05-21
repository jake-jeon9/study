package sample2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FooTestApp {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample2/applicationContext.xml");

		context.close();
	}
}
