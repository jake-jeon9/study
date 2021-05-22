package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setAttribute("req_page", "../member/loginForm.jsp");
		return "../main/index.jsp";
	}

}
