package baekjun1;
import java.io.IOException;
import java.util.Scanner;

public class back10950{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	
	int times = sc.nextInt();
	//int[] result = new int[times];
	for (int i = 0; i<times;i++) {
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(x+y);
		/*
		result[i] = x+y;
		if (i == times) {
			for (int j = 0; j<times;j++) {
				System.out.println(result[j]);
			}
		}
		*/
	}
	
}
	
}


