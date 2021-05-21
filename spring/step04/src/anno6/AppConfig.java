package anno6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//bean.xml 역할을 하는 클래스
@Configuration
public class AppConfig {
	//<bean id="myService" class="anno6.UserServiceImpl"/>
	@Bean
	public UserService myService() { // 아이디가 함수명, 리턴 및 생성자는 클래스
		return new UserServiceImpl();
	}
}
