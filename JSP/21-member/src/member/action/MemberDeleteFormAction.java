package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MemberDeleteFormAction implements Action{

	
	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = (String)request.getAttribute("id");
		
		System.out.println("맴버 딜리트 폼 액션 에서 id는??"+id);
		
		request.setAttribute("req_page", "../member/deleteForm.jsp");
		
		request.getSession().setAttribute("id", id);
		request.getSession().getAttribute("id");
		
		return "../main/index.jsp";
	}
    
    
}
