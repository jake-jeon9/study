package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteFormAction implements Action  {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/board/boardWriteForm.jsp";
	}

}
