package anno4;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class School {
	//autowired는 주입시킬 bean 객체를 찾을 때,
	//1. 자료형이 한개인 멤버변수는 똑같은 자료형을 찾음  
	//2. 같은 자료형의 멤버변수가 여러개인 경우에는 이름이 같은 것을 찾음
	/*  @Autowired
	@Qualifier
	두개를 결합
	*/
   @Resource(name="hong")
	public Student person;
   
	@Autowired
	@Qualifier("grade")
	public int grade;
	
	
	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}

	public Student getPerson() {
		return person;
	}

	public void setPerson(Student person) {
		this.person = person;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
