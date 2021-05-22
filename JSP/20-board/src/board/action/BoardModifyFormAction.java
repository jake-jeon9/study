package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyFormAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		int pageInfo = Integer.parseInt(request.getParameter("pageInfo"));
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		BoardDAO boardDAO = new BoardDAO();
		BoardBean boardBean = new BoardBean();
		
		boardBean=boardDAO.selectArticle(board_num);
		
		request.setAttribute("boardBean", boardBean);
		request.setAttribute("pageInfo", pageInfo);
		
		String forward="/board/board_modify.jsp";
		
		return forward;
	}

}
