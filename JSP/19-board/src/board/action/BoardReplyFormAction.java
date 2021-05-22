package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardReplyFormAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 데이터 처리
		int pageInfo = Integer.parseInt(request.getParameter("pageInfo"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		//2.DB작업
		BoardDAO boardDAO = new BoardDAO();
		BoardBean boardBean = 	boardDAO.selectArticle(board_num);
		
		//3.데이터 공유
		request.setAttribute("boardBean",boardBean);
		request.setAttribute("pageInfo",pageInfo);
		
		//4.view처리
		String forward = "/board/board_reply.jsp";
		return forward;
	}

}
