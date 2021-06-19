package baekjun1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Xbaek1011 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int item = Integer.parseInt(br.readLine());
		int[] result = new int[item];
		
		for(int i = 0 ; i< item; i++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(line.nextToken());
			int y = Integer.parseInt(line.nextToken());
			
			
		}
		
	}
	
}

/*
https://www.acmicpc.net/problem/1011
*/