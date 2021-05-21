package aop06;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person{
	public void classwork() {
		//핵심 관심사항
		System.out.println("컴퓨터를 켜고 Shopping을 시작한다");
	}
	
	
}
