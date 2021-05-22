package tojeju;

import java.util.Calendar;

public class MemberDTO {
	
	private String id;
	private String pw;
	private String name;
	private String birth;
	private int age;
	
	Calendar cal = Calendar.getInstance();
	
	public MemberDTO() {
		super();
	}
	
	public MemberDTO(String id, String pw,String name, String birth, int age ) {
		super();
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.id = id;
		this.pw = pw;
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;

	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	

}
