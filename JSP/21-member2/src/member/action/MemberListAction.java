package member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MemberListAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// <<<<<<< 데이터 >>>>>>>
		   int pg = Integer.parseInt(request.getParameter("pg"));

		   int endNum = pg * 5;
		   int startNum = endNum - 4;
		   
		   MemberDAO memberDAO = new MemberDAO();
		   List<MemberDTO> list = memberDAO.selectList(startNum, endNum);

		    int totalMem = memberDAO.countList();  // 총 글 수 구하기 (36개)
		    int totalMemP = (totalMem + 4)/5;      // 총 페이지수 계산 
		           
		    int startPage = (pg-1)/3*3 +1;       
		    int endPage = startPage + 2 ;
		    if(endPage > totalMemP) endPage = totalMemP;
		   
		
			request.setAttribute("totalMemP",totalMemP);
			request.setAttribute("startPage",startPage);
			request.setAttribute("endPage",endPage);
			request.setAttribute("pg",pg);
			request.setAttribute("memberDTO",list);
			request.setAttribute("req_page", "../member/memberList.jsp");

//			System.out.println("totalMemP : "+totalMemP);
//			System.out.println("startPage ; "+startPage);
//			System.out.println("endPage : "+endPage);
//			System.out.println("pg : "+pg);
//			System.out.println("memberDTO : "+list);
			
		return "../main/index.jsp";
	}
}
