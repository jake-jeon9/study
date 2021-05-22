package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MemberWriteProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 한글 설정
		// 한글 설정이라고 써둔거 보이시죠? 저희가 form의 type을 get방식이 아니라 post 방식으로 보냈기때문에 모든 데이터는 binary(2byte)형태로 전송됩니다.
		// 여기서 한글은 3byte로 처리되기때문에 한글로 하면 깨져요 ㅎ. 그래서 아래 18번째줄 코드처럼 utf-8로 엔코딩 시켜주는겁니다.
		request.setCharacterEncoding("UTF-8");
		// form으로 날린 데이터는 아래처럼 getParameter("파라미터 변수명"); 으로 불러오게됩니다.
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
		
	    
		// 이제 불러온 데이터를 memberDTO라는 javabean클래스에 하나씩 setter로 저장하게됩니다.
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
	    // 회원가입할때 입력한 내용들이 parameter로 전송되서 setter로 저장됐습니다.
	    
	    MemberDAO memberDAO = new MemberDAO();
	    // 이제 memberDAO로 넘어가보죠. 거기보시면 write라는 함수가 있을겁니다. 거기에 제가 저장한 DTO를 매개변수로, DataBase에 저장하는겁니다.
	    // DAO의 write 함수로 넘어가죠.
	    int su = memberDAO.write(memberDTO);
	    // 자 이제 su가 1이라는건 DAO에서 확인하셨을 겁니다. 뭐 하나저장했는데 당연히 1이겠죠 ㅎㅎ.. 아니면 할말없음 근데 상관도 없음여. 그냥 0이면 실패한거고 1이상이면 성공한거에여
	    
	    // forward는 이 execute 함수의 반환값으로 제가 이동할 주소값을 저장하게됩니다.
	    String forward = null;
	    
	    // 위에서 설명했다시피 만약 su가 0이면 0개행이 생성되었다는거고, 이는 어떻게든 저장에 실패했다는거죠. id값이 unique값이라 중복으로 못 들어가니, 중복검사 확실하게 해서, 없는 아이디만 회원가입시키셔야합니다!
	    if(su == 0) { // 저장 실패
	    	// 57~62코드는 솔직히 jsp를 하나 더 만들어도되는데, alert랑 history.back 꼴랑 두개쓴다고 jsp파일을 만드는건 좀 과하잖아여.. 그래서 그냥 외우세여! 이렇게 씁니다.
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록 실패');");
			out.println("history.back();");
			out.println("</script>");
		} else {			   // 저장 성공
			// 자 이제 저장성공을 했으면 su가 0은 아닐거니까 else로 넘어오게돼요. 여기서 저장한 su값을 setattribute를 통해 공유해주시고
			// index에 req=memberWritePro를 전달해줍니다. 자 그럼 다시 index로 가볼까요?
			request.setAttribute("su", su);
			forward = "./index.jsp?req=memberWritePro";
		}
	    
		return forward;
	}

}
