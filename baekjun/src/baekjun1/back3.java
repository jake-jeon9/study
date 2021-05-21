package baekjun1;
import java.io.IOException;
import java.util.Scanner;

public class back3 {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	int x = sc.nextInt();
	
	switch(x/10) {
	case  10:
	case 9: System.out.println("A");
		break;
	case 8: System.out.println("B");
		break;
	case 7 : System.out.println("C");
		break; 
	case 6 : System.out.println("D");
		break;
		default :System.out.println("F");
	}
	
}
	
}


