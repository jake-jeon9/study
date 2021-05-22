package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardDetailAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int pageInfo = 1;
		int board_num=1;
		
		if(request.getParameter("pageInfo") !=null) {
			pageInfo = Integer.parseInt(request.getParameter("pageInfo"));
		}
		
		if(request.getParameter("board_num") !=null) {
			board_num=Integer.parseInt(request.getParameter("board_num"));
		}
		BoardDAO boardDAO = new BoardDAO();
		
		//조회수 증가
		int readCount = boardDAO.updateReadCount(board_num);
		//System.out.println("페이지 조회수 증가? " +readCount);
		
		
		//페이지 호출
		BoardBean boardBean = new BoardBean();
		boardBean =boardDAO.selectArticle(board_num);
		
		
		request.setAttribute("boardBean",boardBean);
		request.setAttribute("pageInfo",pageInfo);
		
		//3. view 처리 파일이름 리턴
		String forward = "board/board_view.jsp";
	
	

		return forward;
	
	}
}
