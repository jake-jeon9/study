package baekjun1;
import java.io.IOException;
import java.util.Scanner;


public class baek10871 {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	
	int times = sc.nextInt();
	int pointNumber = sc.nextInt();
	
	for (int i = 0 ; i < times ; i ++) {
		int getNum = sc.nextInt();
		if (getNum< pointNumber) {
			System.out.print(getNum+" ");
		}
		
	}
	

	
}
	
}


