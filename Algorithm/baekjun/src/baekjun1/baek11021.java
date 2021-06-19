package baekjun1;
import java.util.*;

public class baek11021 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		int round = sc.nextInt();
		String result ="";
		for(int i = 1; i<=round;i++) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			result +="Case #"+i+": "+(A+B)+"\n";
		}
		System.out.println(result);
	
	}
}
