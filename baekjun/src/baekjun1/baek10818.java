package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baek10818 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int times = Integer.parseInt(br.readLine());
		int item[] = new int[times];
		String[] strs = br.readLine().split(" ");
		
		for(int i = 0; i< times ; i++) {
		item[i] = Integer.parseInt(strs[i]);
		}
		
		int min = item[0];
		int max = item[0];
		
		for ( int i = 1; i<times;i++) {
			//�ּҰ�
			if( min> item[i]) {
				min = item[i];
			}
			
			//�ִ밪
			if( max< item[i]) {
				max = item[i];
			}
		}
		bw.write(String.format("%d %d",min,max));
		bw.flush();
		bw.close();
	}
}
