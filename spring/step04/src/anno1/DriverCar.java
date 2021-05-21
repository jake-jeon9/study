package anno1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverCar {
	public static void main(String[] args) {
		//1. 스프링 컨테이너 구동
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("anno1/bean.xml");
		
		//2. bean객체 얻기
		Tire tire = (Tire) context.getBean("test");
		System.out.println(tire.getBrand());
		
		Car car = (Car) context.getBean("car");
		//car.setTire(tire);
		car.drive();
		//3. 스프링 컨테이너 종료
		context.close();
	}
}
