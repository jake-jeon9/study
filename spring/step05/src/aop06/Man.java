package aop06;

import org.springframework.stereotype.Component;

//빈객체로 선언.
@Component
public class Man implements Person{
	
	public void classwork() {
		//핵심 관심사항
		System.out.println("컴퓨터를 켜고 Game을 시작한다");
	}
}
