package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MemberModifyFormReadyAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = (String)request.getSession().getAttribute("memId");
		
		//System.out.println(" 수정화면에서 Id 는? "+ id);
		MemberDAO memberDAO = new MemberDAO();
		String currentPwd = memberDAO.passCheck(id);
		
		MemberDTO memberDTO = memberDAO.getMyInfo(id);
		
		request.setAttribute("id", id);
		request.setAttribute("currentPwd", currentPwd);
		request.setAttribute("memberDTO", memberDTO);
		request.setAttribute("req_page", "../member/modifyForm.jsp");
		
		
		return "../main/index.jsp";
	}

}
