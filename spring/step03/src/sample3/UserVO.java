package sample3;

public class UserVO {

	private String userName;
	
	

	public UserVO(String userName) {
		super();
		this.userName = userName;
		System.out.println("UserVO(String userNaem) 호출");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
