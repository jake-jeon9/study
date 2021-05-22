package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardReplyProAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.데이터 처리

		int pageInfo = Integer.parseInt(request.getParameter("pageInfo"));
		BoardBean boardBean = new BoardBean();
	    boardBean.setBoard_name(request.getParameter("board_name"));
	    boardBean.setBoard_pass(request.getParameter("board_pw"));
	    boardBean.setBoard_subject(request.getParameter("board_subject"));
	    boardBean.setBoard_content(request.getParameter("board_content"));
	    boardBean.setBoard_re_ref(Integer.parseInt(request.getParameter("board_re_ref")));
	    boardBean.setBoard_re_lev(Integer.parseInt(request.getParameter("board_re_lev")));
	    boardBean.setBoard_re_seq(Integer.parseInt(request.getParameter("board_re_seq")));
	      
		//2. DB
	      BoardDAO boardDAO = new BoardDAO();
		int result = boardDAO.insertReplyArticle(boardBean);
		
		String forward = "";
		if(result>0) {
			forward="boardList.do?page="+pageInfo;
		}else {
			forward=null;
			response.setContentType("text/html; charset=UTF-8");
	    	  PrintWriter out = response.getWriter();
	    	  out.println("<script>");
	    	  out.println("alert('저장 실패..! 다시 시도해주세요.');");
	    	  out.println("history.back();");
	    	  out.println("</script>");
		}
		
		//3데이터 공유
		//4.view처리 
		// ~.jsp or ~.do 
		
		
		
		return forward;
	}

}
