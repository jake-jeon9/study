package anno1;

import org.springframework.stereotype.Component;

/*
 * 
 * <bean id="koreaTire" class="anno1.koreaTire"/>와 같은설정
 *=>@component 에서 id를 설정하지 않으면, 기본값으로 클래스이름의 첫글자가 소문자로 id가 자동설정됨.
 * <bean id="test" class="anno1.KoreaTire"/>와 같은 설정
 */
@Component("test")
public class KoreaTire implements Tire{

	
	
	@Override
	public String getBrand() {
		return "한국 타이어";
	}

}
