package test2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
public static void main(String[] args) {
	
	GenericXmlApplicationContext context = 
			new GenericXmlApplicationContext("test2/bean.xml");
	
	Calc calcAdd = (Calc) context.getBean("CalcAdd");
	Calc calcMul = (Calc) context.getBean("CalcMul");
	
	calcAdd.calculate();
	calcMul.calculate();
	
	context.close();
}
}