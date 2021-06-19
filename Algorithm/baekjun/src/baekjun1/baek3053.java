package baekjun1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek3053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	 int R = Integer.parseInt(br.readLine());
	 
	 double N = Math.pow(R, 2) * Math.PI;
	 
	 double K = Math.pow(R, 2) * 2;
	 
	 System.out.printf("%.6f",N);
	 System.out.println();
	 System.out.printf("%.6f",K);
	 
	}
}
