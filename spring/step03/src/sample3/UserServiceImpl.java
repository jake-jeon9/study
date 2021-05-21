package sample3;

public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
		System.out.println("UserServiceImpl() 호출");
	}
	
	@Override
	public void addUser(UserVO vo) {
	System.out.println("addUser(UserVO vo) 호출됨");	
	System.out.println("이름 : "+vo.getUserName());	
	}

}
