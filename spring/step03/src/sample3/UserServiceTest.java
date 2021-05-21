package sample3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceTest {
	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample3/bean.xml");

		UserService u1 = (UserService) context.getBean("userService");

		UserVO vo = new UserVO("강호동");
		u1.addUser(vo);

		System.out.println("u1 : " + u1);
		System.out.println("------------------");

		UserService u2 = (UserService) context.getBean("userService");
		UserVO vo1 = new UserVO("홍길동");
		u2.addUser(vo1);

		System.out.println("u2 : " + u2);
		System.out.println("------------------");

		context.close();

	}
}
