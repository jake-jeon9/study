package exam2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam2.message.Action;
import exam2.message.MessageGuestAction;
import exam2.message.MessageHostAction;
import exam2.message.MessageMismatchAction;
import exam2.message.MessageNullAction;

@WebServlet("/MessageController2")
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
		String view = null;
	
		//2. 요청정보확인
		message = request.getParameter("message");
		
		//3.요청 작업 처리(데이터처리) -> 각 클레스에서 처리
		
		//4.요청 처리 결과를 request객체에 저장
		// 부모클래스를 생성하고 자식을 품게하여 사용.
		Action action = null;	
		
		if(message == null) {
			action = new MessageNullAction();
		}else if(message.equals("host")) {
			action = new MessageHostAction();
		}else if(message.equals("guest")) {
			action = new MessageGuestAction();
		}else {
			action = new MessageMismatchAction();
		}
		
		if(action != null) {
			try {
			view = action.process(request,response);
			}catch(Throwable e) {
				e.printStackTrace();
			}
		}
		
		
		//5. 응답을 위한 view를 선택하고, forward방식으로 이동
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
		
	}
	
	


}
