package exam1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MessageController")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MessageController() {
        super();
    }

    //1. 브라우저 요청받기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doRequest(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String message = null;
		Object result = null;
		//2. 요청정보확인
		message = request.getParameter("message");
		
		//3.요청 작업 처리(데이터처리)
		
		if(message == null) {
			result = "전달된 내용이 없다.";
			
		}else if(message.equals("host")) {
			result = "이쁜 아이유입니다.";
			
		}else if(message.equals("guest")) {
			result = "귀여운 아이유 입니다.";
			
		}else {
			result = "가수 아이유 입니다.";
			
		}
		
		//4.요청 처리 결과를 request객체에 저장
		request.setAttribute("result",result);
		
		
		
		//5. 응답을 위한 view를 선택하고, forward방식으로 이동
		//http://localhost:8090/18-mvc/messageView.jsp
		//->http://localhost:8090/18-mvc/ : 18-mvc/WebContent/
		// 슬레쉬 / 가 없으면  해당 폴더절대경로를 자동으로 붙여주고 
		// / 가 있으면 해당 폴더 위치 기준으로 처리.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/messageView.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	


}
