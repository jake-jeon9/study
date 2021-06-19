package baekjun1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek9020 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] arr2 = new int[10001];
		
		for(int i = 2 ; i<=10000;i++) {
			arr2[i] = i;
			for(int j = 2;j<=Math.sqrt(i);j++) {
				if(i%j == 0) {
					arr2[i] = 0;
					break;
				}
			}
		}
		
		for(int j = 0; j<T; j++) {
			int n = Integer.parseInt(br.readLine());
			int tempF =0;
			int tempB = 0;
			int gap = 999999;
			for(int i = 2;i<=n-i;i++) {
				if(arr2[i]+arr2[n-i] == n) {
					if(Math.abs(i-(n-i))<=gap) {
						tempF = i;
						tempB = n-i;	
						gap =Math.abs(i-(n-i)); 
					}
				}
			}
			System.out.println(tempF<=tempB?(tempF+" "+tempB):(tempB+" "+tempF));
		}
	}
}
