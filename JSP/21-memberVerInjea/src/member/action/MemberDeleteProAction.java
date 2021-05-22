package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

public class MemberDeleteProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("memId");

		MemberDAO memberDAO = new MemberDAO();
		
		int result = memberDAO.delete(id);
		request.setAttribute("result", result);
		
		return "./index.jsp?req=memberDeletePro";
	}

}
