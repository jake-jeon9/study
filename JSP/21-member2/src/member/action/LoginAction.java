package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import member.dao.MemberDAO;

public class LoginAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		MemberDAO memberDAO = new MemberDAO();
		String name = memberDAO.login(id, pwd);
	
		if(name != null) {				//로그인 성공
			request.setAttribute("id",id);
			request.setAttribute("name",name);
			
			
			
			request.setAttribute("req_page","../member/loginOk.jsp");
		} else {						//로그인 실패

			request.setAttribute("req_page","../member/loginFail.jsp");
			
		}
		System.out.println("name?" + name);
		return "../main/index.jsp";
	}

}
