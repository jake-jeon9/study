package baekjun1;

import java.util.*;

public class baek2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		int R = N%5;
		if(N == 4 || N == 7) result = -1;
		else if(R == 0) result = N/5;
		else {
			result = R%2 == 1 ? (N/5)+1 : (N/5)+2;
		}
		System.out.println(result);
	}
}
