package anno5;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service // @component 와 같음
@Scope("singleton") // singleton : 객체를 1개만 생성, prototype : 매번 객체 생성
public class MyMessage {
	String message;
	
	public MyMessage() {
		message = "즐겁게 삽시다";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
