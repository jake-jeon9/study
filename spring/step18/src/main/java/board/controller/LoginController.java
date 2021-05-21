package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.dao.MemberDAO;

@Controller
public class LoginController{

	@RequestMapping(value = "/member/login.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터 읽기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// DB
		MemberDAO memberDAO = new MemberDAO();
		String name = memberDAO.login(id, pwd);
		// 화면 네비게이션
		// ModelAndView : spring의 DispatcherServlet에 공유정보와 view 처리 파일 정보를 전달하는 클래스
		ModelAndView modelAndView = new ModelAndView();
		
		if(name == null) { // 로그인 실패
			//return "loginForm";		//"loginForm.jsp";
			modelAndView.setViewName("loginForm.jsp");
		} else {  // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
			session.setAttribute("memName", name);			
			//return "../board/boardList.do?pg=1";	
			modelAndView.setViewName("redirect:../board/boardList.do?pg=1");
		}		
		return modelAndView;
	}

}




