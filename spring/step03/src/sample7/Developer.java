package sample7;

public class Developer extends Emp{

	private String dept;

	public Developer(String name, int salary) {
		super(name, salary);
	}
	
	public Developer() {
		
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Developer [ dept = " +dept +", "+ super.toString()+ "]";
	}
	
	

}
