package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class back1712 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String strs[] = br.readLine().split(" ");
		int fixed = Integer.parseInt(strs[0]);
		int cost = Integer.parseInt(strs[1]);
		int price =Integer.parseInt(strs[2]);
		
		int bep =1;
		int gap = price-cost;
		
		if ( cost >= price) {
			bw.write("-1");
			bw.flush();
			bw.close();
			return;
		}

		while(true) {
			if(bep*gap<=fixed) {
				 bep++;
			}else {
				break;
			}
		}
	
		bw.write(bep+"");
		bw.flush();
		bw.close();
	}
}
