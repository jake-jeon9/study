package baekjun1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek1929 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(line.nextToken());
		int N = Integer.parseInt(line.nextToken());

		
		boolean[] arr = new boolean[N+1];
		
		//true는 소수
		
		arr[0] = arr[1] = true;
		
		for(int i = M; i<=N;i++) {
			for(int j = 2; j<=Math.sqrt(i);j++) {
				if(i%j==0) {
					arr[i] = true;
					break;
				}
			}
			if(!arr[i]) System.out.println(i);
		}

	}
}
