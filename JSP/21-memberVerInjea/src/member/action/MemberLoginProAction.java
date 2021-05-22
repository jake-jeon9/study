package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

public class MemberLoginProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 인풋으로 입력받은 id와 패스워드를 받기
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// DAO 중 login 함수에 id와 pwd 값 전달해주기! (name을 얻음)
		MemberDAO memberDAO = new MemberDAO();
		String name = memberDAO.login(id, pwd);
		String forward = null;
		
		// 세션 얻어오는법 2가지
		// HttpSession session = request.getSession();
		
		// 메서드 체인 방식.
		// session.getAttribute = request.getSession().getAttribute
		// String id = (String)request.getSession().getAttribute("memId");
		
		// 페이지 이동 (html에서는 a태그, 자바코드에서는 response)
		// 세션으로 공유데이터 사용
		if(name != null) {				//로그인 성공
			request.setAttribute("name", name);
			request.setAttribute("memId", id);
			forward = "./index.jsp?req=LoginOK";
		} else {						//로그인 실패
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
