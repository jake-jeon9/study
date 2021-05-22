package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션을 통해서 서블릿 등록
@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public PersonServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 데이터 처리
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		String color = request.getParameter("color");
		String[] subject = request.getParameterValues("subject");
		
		// 2. 응답 : HTML 문서
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body bgcolor='" + color +"'>");
		out.println("<ul>");
		out.println("<li>이름 : " + name +"</li>");
		String result = "";
		if(gender.equals("0")) result = "남자";
		else result = "여자";
		out.println("<li>성별 : " + result +"</li>");
		result = "";
		for(int i=0; i<hobby.length; i++) {
			result += hobby[i] + " ";
		}
		out.println("<li>취미 : " + result +"</li>");
		out.println("<li>색깔 : " + color +"</li>");
		result = "";
		for(int i=0; i<subject.length; i++) {
			result += subject[i] + " ";
		}
		out.println("<li>이름 : " + result +"</li>");
		out.println("</ul>");
		//out.println("<a href='#' onclick='history.back(); return false;'>뒤로</a>");
		out.println("<a href='javascript:history.back()'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}








