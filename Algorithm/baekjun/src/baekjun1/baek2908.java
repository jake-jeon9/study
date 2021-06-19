package baekjun1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String item =br.readLine();
		String OA = item.substring(0,3);
		String OB = item.substring(4);
		
		String CA ="";
		String CB ="";
		
		for(int i = 2; i>=0;i--) {
			CA +=OA.charAt(i);
			CB +=OB.charAt(i);
		}
		
		int A = Integer.parseInt(CA);
		int B = Integer.parseInt(CB);
		
		System.out.println(A>B?A:B);
		
		
		
		
	}
}

