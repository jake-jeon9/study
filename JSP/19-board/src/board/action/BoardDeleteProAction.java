package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;

public class BoardDeleteProAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		int pageInfo = 1;
		int board_num=0;
		String forward="";
		String getPassword = request.getParameter("form_password");
		
		if(request.getParameter("pageInfo") !=null) {
			pageInfo = Integer.parseInt(request.getParameter("pageInfo"));
		}
		
		if(request.getParameter("board_num") !=null) {
			board_num=Integer.parseInt(request.getParameter("board_num"));
		}
		//System.out.println("입력한 패스워드 " +getPassword);
		//System.out.println("넘어온 pageInfo : " + pageInfo);
		//System.out.println("넘어온 글번호board_num : "+board_num);
		
		//비밀번호 불러오기
		BoardDAO boardDAO = new BoardDAO();
		boolean result=boardDAO.getPassword(board_num,getPassword);		
		
		if(result) {
			int getResult = boardDAO.deleteArticle(board_num);
			
			if(getResult>0) {
				response.setContentType("text/html; charset=UTF-8");
	    	  PrintWriter out = response.getWriter();
	    	  out.println("<script>");
	    	  out.println("alert('해당글이 삭제되었습니다. .');");
	    	  out.println("</script>");
	    	forward = "boardList.do?page="+pageInfo; // 삭제완료시 리스트로 고고
			}else {
			response.setContentType("text/html; charset=UTF-8");
	    	  PrintWriter out = response.getWriter();
	    	  out.println("<script>");
	    	  out.println("alert('삭제실패..! 다시 시도해주세요.');");
	    	  out.println("history.back();");
	    	  out.println("</script>");
	    	  forward=null;// 알럿을 띄울려면 forward를 널로해야됨. 아니면 아래코드
	    	//forward ="boardDetail.do?page="+pageInfo+"&board_num="+board_num;
			}
	
		}else {
		//실패시 다시 해당 페이지로 가기
		//forward ="boardDetail.do?page="+pageInfo+"&board_num="+board_num;
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
