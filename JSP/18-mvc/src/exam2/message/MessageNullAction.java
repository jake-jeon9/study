package exam2.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageNullAction  implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1. 클라이언트에서 전달된 데이터 확인
		//2. 데이터 처리작업
		//3. 결과값을 request 객채에 저장
		//경우에따라 1~3은 생략될 수 있음.
		request.setAttribute("result", "if/null = 전달된 내용이 없습니다.");
		//4. view 처리 파일 이름 리턴
		return "/messageView.jsp";
	}
	

}
