package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

public class MemberModifyProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("memId");

		String password = request.getParameter("pwd");
		String num1 = request.getParameter("tel1");
		String num2 = request.getParameter("tel2");
		String num3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		MemberDAO memberDAO = new MemberDAO();
		String currentPwd = memberDAO.passCheck(id);
		
		int su = memberDAO.modify(password, num1, num2, num3, email1, email2, addr, id);
		
		request.setAttribute("su", su);
		return "./index.jsp?req=memberModifyPro";
	}

}
