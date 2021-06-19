package baekjun1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek4948 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int cnt=0;
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) break;
			
			for(int i = num+1; i<=2*num;i++){
				boolean isPre = false;
				for(int j = 2; j<=Math.sqrt(i);j++) {
					if(i%j==0) {
						
						isPre = true;
						break;
					}	
				}
				if(!isPre) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		
	}
}
