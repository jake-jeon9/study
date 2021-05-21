package baekjun1;
import java.io.IOException;
import java.util.Scanner;

public class back2 {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	int x = sc.nextInt();
	for(int i = 1;i<=9;i++) {
		int result = i * x;
		System.out.println(String.format("%d * %d = %d", x,i,result));
	}
	
}

}
