package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

public class MemberCheckIdAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		//DB 처리
		MemberDAO memberDAO = new MemberDAO();
		boolean exist = memberDAO.isExistedId(id);		// true : id가 있음, 사용불가
														// false: id가 없음, 사용가능
		String result="";
		if(exist) {
			result="이미 사용중입니다.";
			
		}else {
			result="사용가능!";
		}
		
		request.setAttribute(" id",  id);
		request.setAttribute("result", result);
		request.setAttribute("exist", exist);
		
		return "../member/checkId.jsp";
	}

}
