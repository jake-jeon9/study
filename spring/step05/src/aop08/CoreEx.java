package aop08;

public class CoreEx {
	
	public void zeroMethod(int a, int b) {
		try {
			//int타입은 나눌 값이 0이 왔을 떄 오류가 발생
		System.out.println(a + " / "+ b + " = " + (a/b));
		}catch (Exception e) {
			throw new RuntimeException("0으로 나눌 수 없습니다.");
		}
	}
}
