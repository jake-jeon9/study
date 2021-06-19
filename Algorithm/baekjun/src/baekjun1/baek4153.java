package baekjun1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer item = new StringTokenizer(br.readLine());
			
			int f = Integer.parseInt(item.nextToken());
			int s = Integer.parseInt(item.nextToken());
			int t = Integer.parseInt(item.nextToken());
			if(f+s+t == 0) break;
			
			
			System.out.println(f*f + s*s == t*t||f*f+t*t==s*s||s*s+t*t==f*f ? "right":"wrong"); 
			
		}
		
		
	}
}
