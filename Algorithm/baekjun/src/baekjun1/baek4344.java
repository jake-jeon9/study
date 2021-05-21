package baekjun1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baek4344 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int Case= Integer.parseInt(br.readLine());
		double[] avg = new double[Case];
		int counter[] = new int[Case];
		for(int i = 0; i<Case;i++) {
			String[] strs = br.readLine().split(" ");
			int itemNum =Integer.parseInt(strs[0]);
			int total = 0;
			for (int k = 1; k<=itemNum;k++) {
				total += Integer.parseInt(strs[k]);
			}
			
			avg[i] = total/itemNum;
			counter[i] = 0;
			for (int k = 1; k<=itemNum;k++) {
				if (avg[i]<Integer.parseInt(strs[k])){
					counter[i]++;
				}
			}
			
			avg[i] = (double)Math.round(counter[i]*100000)/itemNum/1000;			
		}
		
		for(int i = 0; i<Case;i++) {
			String chars = String.format("%.3f",avg[i]) +"%";
			System.out.println(chars);
		}
		
			
	}
}

