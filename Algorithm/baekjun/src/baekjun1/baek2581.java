package baekjun1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2581 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int min = N+1;
		int sum = 0;
		for(int i = M;i<=N;i++) {
			if(i<2) continue;
			
			boolean isPre = false;
			for(int j =2;j<=Math.sqrt(i);j++) {
				if(i%j==0) {
					isPre= true;
					break;
				}
			}
			if(isPre) continue;
			if(i<min) {
				//System.out.println("최소값 갱신");
				min = i;
			}
			sum+=i;
			//System.out.println("현재 번호 : "+i);
			//System.out.println("현재까지 합 : "+sum);
		}
			System.out.println(sum<1? -1:(sum+"\n"+min));
		
		
	}
}
