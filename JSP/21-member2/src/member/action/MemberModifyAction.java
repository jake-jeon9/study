package member.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MemberModifyAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		String id = (String)request.getSession().getAttribute("memId");

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
		
		
		MemberDTO memberDTO= memberDAO.getMyInfo(id);
		
		request.setAttribute("su", su);
		request.setAttribute("currentPwd", currentPwd);
		request.setAttribute("memberDTO", memberDTO);
		request.setAttribute("req_page", "../member/modify.jsp");
		
		//System.out.println("su ? " + su);
		//System.out.println("currentPwd ? " + currentPwd);
		//System.out.println("memberDTO,id : " + memberDTO.getId());
		
		return "../main/index.jsp";
	}

}
