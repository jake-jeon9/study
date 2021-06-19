package baekjun1;

import java.util.Scanner;

public class baek10869 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int ten = (B%10)*A;
		int hund = (B%100)*A-ten;
		int thou = A*B-hund-ten;
		System.out.println(ten);
		System.out.println(hund/10);
		System.out.println(thou/100);
		System.out.println(A*B);
		
	}
}
