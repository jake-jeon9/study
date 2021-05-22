package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardWriteProAction  implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//1. 데이터 처리
		
		String realFolder = "";
		String saveFolder = "/boardUpload";
		int fileSize = 5*1024*1024;
		
	    realFolder = request.getServletContext().getRealPath(saveFolder);
	    
//	    System.out.println("request 는? "+request);
//	    System.out.println("request.getServletContext() 는? "+request.getServletContext());
//	    System.out.println("request.getServletContext().getRealPath 는? "+request.getServletContext().getRealPath(""));
	    
	    
	      MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, 
	            "UTF-8", new DefaultFileRenamePolicy());
	      // 파라미터값 얻기
	      BoardBean boardBean = new BoardBean();
	      boardBean.setBoard_name(multi.getParameter("board_name"));
	      boardBean.setBoard_pass(multi.getParameter("board_pw"));
	      boardBean.setBoard_subject(multi.getParameter("board_subject"));
	      boardBean.setBoard_content(multi.getParameter("board_content"));
	      boardBean.setBoard_file(multi.getOriginalFileName("board_file"));
	      
	      //DB 
	      BoardDAO boardDAO = new BoardDAO();
	      int insertCount = boardDAO.insertArticle(boardBean);
	      // 2. 데이터 공유
	      //=> 간단한 것은 굳이 jsp 파일에서 작업을 안하고 여기서 작업함.
	      String forward = null;
	      
	      if(insertCount ==0) {//저장 실패
	    	  response.setContentType("text/html; charset=UTF-8");
	    	  PrintWriter out = response.getWriter();
	    	  out.println("<script>");
	    	  out.println("alert('등록실패');");
	    	  out.println("history.back();");
	    	  out.println("</script>");
	      } else {
	    	  forward = "boardList.do";
	    	  
	      }
	      // 3. view 처리 파일이름 리턴
	      return forward;
	}

}
