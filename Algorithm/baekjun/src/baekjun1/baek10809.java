package baekjun1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] position = new int[26];
		
		String result = "";
		
		String item = br.readLine();
		Arrays.fill(position, -1);
		
		for(int i = 0; i<item.length();i++) {
			int p = item.charAt(i) - 'a';
			if(position[p] == -1) position[p] = i ;
			
		}
		for(int i = 0; i<position.length;i++) {
			if(i ==position.length-1) {
				result+=position[i];
			}else {
				result = result + position[i] +" ";	
			}
			
		}
		
		System.out.println(result);
		
	}
}
