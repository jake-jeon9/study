package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HelloServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
    
    public HelloServlet() {
        super();
    }
    // 서블릿 클래스가 처음 구동될 때, 톰캣서버가 호출 시킴
    // init() : 서블릿 클래스 초기화
    @Override
	public void init() throws ServletException {
		System.out.println("init() 호출");
	}
    // 서블릿 클래스가 종료될 때, 톰캣서버가 호출 시킴
    // destroy() : 서블릿이 종료될 때 동작시킬 코드 작성
    @Override
	public void destroy() {
    	System.out.println("destroy() 호출");
	}	
    // 클라이언트의 요청이 올 때마다, 톰캣서버가 호출 시킴
    // get 방식으로 요청이 올 때 동작
    // request : 클라이언트로부터 전달된 데이터를 톰캣서버가 request 객체를 만들고 데이트를 저장하고 전달함
    // response : 톰캣서버가 응답 객체를 만들고 전달함
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		// 1. 데이터 처리
		// 2. HTML 문서 작성
		// 지금부터 text문서를 작성할 것이고, 그것은 HTML 문서이고, 엔코딩은 UTF-8이다.
		response.setContentType("text/html; charset=UTF-8");
		// PrintWriter : HTML 문서를 웹서버로 출력을 내보내는 동작을 함
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Hello Servlet!!</p>");
		out.println("<p>안녕하세요. 서블릿!!</p>");
		out.println("<p>안녕하세요. 서블릿!!</p>");
		out.println("</body>");
		out.println("</html>");
		
	}
	// 클라이언트의 요청이 올 때마다, 톰캣서버가 호출 시킴
	// post 방식으로 요청이 올 때 동작
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출");
		doGet(request, response);
	}
}




