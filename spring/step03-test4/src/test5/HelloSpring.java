package test5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("test5/beanCP.xml");
		
		SungjukImpl sungjuk = (SungjukImpl) context.getBean("tes1");
		
		sungjuk.calcTot();
		sungjuk.calcAvg();
		sungjuk.display();
		sungjuk.modify();
		sungjuk.display();
		
		context.close();
		
	}

}
