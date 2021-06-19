package baekjun1;

import java.math.BigInteger;
import java.util.*;

public class baek10757 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		String[] b = s.split(" ");
		
		BigInteger A = new BigInteger(b[0]);
		BigInteger B = new BigInteger(b[1]);		
		
		
		System.out.println(A.add(B));
		
	}
}
