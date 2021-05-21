package baekjun1;
import java.io.IOException;
import java.util.Scanner;

public class baek1 {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	int x = sc.nextInt();
	int y = sc.nextInt();
	
	if(x<y) {
		System.out.println("<");
	}else if(x>y) {
		System.out.println(">");
	}else if(x==y){
		System.out.println("==");
	}
	
}

}
