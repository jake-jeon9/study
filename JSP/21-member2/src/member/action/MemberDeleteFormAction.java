package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;


public class MemberDeleteFormAction implements Action{

	
	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		String id = (String)request.getSession().getAttribute("memId");
		
		//System.out.println("맴버 딜리트 폼 액션 에서 id22는??"+id);
		request.setAttribute("req_page", "../member/deleteForm.jsp");
		request.setAttribute("id", id);
		
		return "../main/index.jsp";
	}
    
    
}
