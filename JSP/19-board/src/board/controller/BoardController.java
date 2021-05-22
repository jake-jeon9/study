package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;
import board.action.BoardDeleteProAction;
import board.action.BoardDetailAction;
import board.action.BoardListAction;
import board.action.BoardModifyFormAction;
import board.action.BoardModifyProAction;
import board.action.BoardReplyFormAction;
import board.action.BoardReplyProAction;
import board.action.BoardWriteProAction;
import board.action.FileDownAction;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

    
    //1. 웹브라우저 요청받기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("utf-8");
		//2.요청정보확인
		String command = request.getServletPath();
		// command : command : /boardWriteForm.do
		//System.out.println("command : " +  command);
		
		//3. 요청 작업 처리
		// 데이터 처리 클래스 선택
		//클래스에서 데이터 처리
		//클래스에서 공유 데이터 처리
		// view 처리 파일 이름 리턴
		String forward = null;
		Action action = null;
		
		if(command.equals("/boardWriteForm.do")) {
			//경로를 설정 할 떄 기준은 브로우저 주소창
			 forward = "/board/boardWriteForm.jsp";
		} else if(command.equals("/boardWritePro.do")){
			action = new BoardWriteProAction();
			
		}else if(command.equals("/boardList.do")) {
			action = new BoardListAction();
			
		}else if(command.equals("/boardDetail.do")) {
			action = new BoardDetailAction();
			
		}else if( command.equals("/board_deleteForm.do")) {
			 forward = "/board/board_delete.jsp";
		
		}else if( command.equals("/boardDeleteProAction.do")) {
			action = new BoardDeleteProAction();
			
		}else if(command.equals("/fileDown.do")) {
			action = new FileDownAction();
		
		}else if(command.equals("/boardModifyForm.do")) {
			action = new BoardModifyFormAction();
			
		}else if(command.equals("/boardModifyPro.do")) {
			action = new BoardModifyProAction();
			
		}else if(command.equals("/boardReplyForm.do")) {
			action = new BoardReplyFormAction();
			
		}else if(command.equals("/boardReplyPro.do")) {
			action = new BoardReplyProAction();
	}
		
		if(action != null) {
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//4.응답을 위한 view 처리파일로, forward 방식 이동
		if(forward != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
			dispatcher.forward(request, response);	
		}

		
	}
	
	
}
