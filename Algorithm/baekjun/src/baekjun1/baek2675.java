package baekjun1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2675 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String result = "";
		for(int i = 0; i<T;i++) {
			String item = br.readLine();
			int times = item.charAt(0) - '0';
			
			item = item.substring(2);
			
			
			for(int j = 0; j<item.length();j++) {
				int count = 0;
				char c = item.charAt(j);
				while(count <times) {
					result+= c;
					count++;
				}
				
			}
			
			result+="\n";
		}
		System.out.println(result);
	}
}
