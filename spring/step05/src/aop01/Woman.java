package aop01;

public class Woman {
	public void classwork() {
		System.out.println("교실문을 연다");
		
		try {
			System.out.println("검큐터를 켜고 Shopping을 시작한다");
		}catch(Exception e) {
			System.out.println("**오늘은 소득하는 날**");
		}finally {
			System.out.println("전들이 켜져 있는지 확인한다.");
		}
		
		System.out.println("교실문을 잠근다.");
	}
}
