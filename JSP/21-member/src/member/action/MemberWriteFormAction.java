package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberWriteFormAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
		request.setAttribute("req_page", "../member/writeForm.jsp");
		return "../main/index.jsp";
	}

}
