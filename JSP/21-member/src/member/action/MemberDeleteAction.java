package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

public class MemberDeleteAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
		String id = (String)request.getAttribute("id");
		System.out.println("id??" +id);
		MemberDAO memberDAO = new MemberDAO();
		
		int result = memberDAO.delete(id);
		
		request.setAttribute("req_page", "../member/delete.jsp");
		request.setAttribute("id", id);
		request.setAttribute("result", result);
		return "../main/index.jsp"; 
	}

}
