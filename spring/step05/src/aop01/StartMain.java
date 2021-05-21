package aop01;

public class StartMain {
	public static void main(String[] args) {
		
		Woman woman = new Woman();
		Man man = new Man();
		
		System.out.println("여학생 입장");
		woman.classwork();
		System.out.println("------------\n");
		System.out.println("남학생 입장");
		man.classwork();
	}
}
