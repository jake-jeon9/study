package baekjun1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back8958 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int Sc= Integer.parseInt(br.readLine());
		
		int[] score = new int[Sc];
		for(int i = 0; i<Sc;i++) {
			String[] strs = br.readLine().split("");
			int scores = 1;
			
			for(int k = 0; k<strs.length;k++) {
				if(strs[k].equals("O")) {
						
					if (k>0&&strs[k-1].equals(strs[k])) {
						scores ++;
						score[i]+=scores;	
					}else {
						score[i]+=scores;
					}
				}else {
					scores = 1;
				}
			}	
		}
		for(int i = 0; i<Sc;i++) {
			System.out.println(score[i]);	
		}
		
		
		
			
	}
}

