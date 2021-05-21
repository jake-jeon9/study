package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baek2577 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int first = Integer.parseInt(br.readLine());
		int second = Integer.parseInt(br.readLine());
		int thrid = Integer.parseInt(br.readLine());
		
		int result = first *second * thrid;
		int length = (int)(Math.log10(result)+1);
				
		String str = ""+result;
		String strs[] = new String[length];
		int count[] = new int[10];
		
		
		for(int i = 0;i<length;i++) {
			strs[i] = str.substring(i,i+1);
			//0 - 1
			int temp = Integer.parseInt(strs[i]);
			count[temp]++;
			
		}
		for(int i = 0;i<10;i++) {
		bw.write(count[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
	
}
