package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MemberWriteAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//한글 설정
		
		request.setCharacterEncoding("UTF-8"); 
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		
		//String tel = request.getParameter("tel1")+"-"+request.getParameter("tel2")+
	    //request.getParameter("tel3"); => 이렇게 한번에 쓸수도 있음!!
	    
	    MemberDTO memberDTO = new MemberDTO();
	    memberDTO.setName(name);
	    memberDTO.setId(id);
	    memberDTO.setPwd(pwd);
	    memberDTO.setGender(gender);
	    memberDTO.setEmail1(email1);
	    memberDTO.setEmail2(email2);
	    memberDTO.setTel1(tel1);
	    memberDTO.setTel2(tel2);
	    memberDTO.setTel3(tel3);
	    memberDTO.setAddr(addr);
	    
	    MemberDAO memberDAO = new MemberDAO();
	    int su = memberDAO.write(memberDTO);
		
		request.setAttribute("id", id);
		request.setAttribute(" su",  su);
		
		return "../main/index.jsp?su="+su;
	}

}
