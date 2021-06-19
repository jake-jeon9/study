package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baek11720 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String item = br.readLine();
		int sum = 0;
		for(int i = 0; i<N;i++) {
			int num = item.charAt(i) - '0';
			sum+=num;
		}
		bw.write(sum+"");
		bw.flush();
		bw.close();
	}
}
