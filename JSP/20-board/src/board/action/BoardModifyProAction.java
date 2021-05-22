package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyProAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		   //1.데이터 처리
		   //2. DB 작업
		   //3.데이터 공유
		   //4. view처리 파일 이름 리턴
		   //->~.jsp : 최종 결과를 보여주기 위함
		   //->~.do : 데이터 처리할 게 있음
		
		BoardBean boardBean = new BoardBean();
		String forward=null;
		
		   boardBean.setBoard_name(request.getParameter("board_name"));
		   boardBean.setBoard_pass(request.getParameter("board_pw"));
		   boardBean.setBoard_subject(request.getParameter("board_subject"));
		   boardBean.setBoard_content(request.getParameter("board_content"));
		   boardBean.setBoard_file(request.getParameter("board_file"));
		   boardBean.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		   int pageInfo = Integer.parseInt(request.getParameter("pageInfo"));
			
			BoardDAO boardDAO = new BoardDAO();
			boolean result = boardDAO.getPassword(boardBean.getBoard_num(),boardBean.getBoard_pass());
		//System.out.println("boardBean.getBoard_num()?" + boardBean.getBoard_num());
		//System.out.println("boardBean.getBoard_pass()??" + boardBean.getBoard_pass());
		//System.out.println("비밀번호 일치? 결과는?" + result);
		
		if(result) {
			int getResult = boardDAO.updateArticle(boardBean);
			
			if(getResult>0) {//업데이트 성공
		    	  forward ="boardDetail.do?page="+pageInfo+"&board_num="+boardBean.getBoard_num();
				
			}else {
				response.setContentType("text/html; charset=UTF-8");
		    	  PrintWriter out = response.getWriter();
		    	  out.println("<script>");
		    	  out.println("alert('업데이트 실패..! 다시 시도해주세요.');");
		    	  out.println("history.back();");
		    	  out.println("</script>");
		    	  forward=null;// 알럿을 띄울려면 forward를 널로해야됨. 아니면 아래코드
			}
		}else {
			 forward=null;
				response.setContentType("text/html; charset=UTF-8");
	    	  PrintWriter out = response.getWriter();
	    	  out.println("<script>");
	    	  out.println("alert('해당글 암호가 일치하지 않습니다.');");
	    	  out.println("history.back();");
	    	  out.println("</script>");
		}
		
		return forward;
	}

}
