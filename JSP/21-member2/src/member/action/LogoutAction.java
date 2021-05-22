package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("로그아웃 함수 액션");
		request.setAttribute("req_page", "../member/logout.jsp");
		
		return "../main/index.jsp";
	}

}
