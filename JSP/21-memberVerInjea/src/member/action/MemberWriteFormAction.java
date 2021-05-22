package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberWriteFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 여길 보시면 따로 설정되어있지 않아요. 다만 servlet을 확인해보시면 action이라는 부모클래스로 자식클래스인 이 클래스를 불러오고, execute를 동작시키라고 나와요
		// 그럼 return값으로 해당하는 주소로 forwarding 시켜주는거에요. 쉽게 말해서 밑에 주소로 이동한다는 뜻이죠.
		// 이제 다시 index로 돌아가요. 그리고 req==memberWriteForm 인 c:if문으로 이동하시면 됩니다.
		return "./index.jsp?req=memberWriteForm";
	}

}
