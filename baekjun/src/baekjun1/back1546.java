package baekjun1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back1546 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int Sc= Integer.parseInt(br.readLine());
		
		double max = 0;
		
		double subject[] = new double[Sc];
		String[] strs = br.readLine().split(" "); 
		for (int i = 0; i<Sc;i++) {
			subject[i] = Integer.parseInt(strs[i]);
		}
		max = subject[0];
		for (int i = 1; i<Sc;i++) {
			if(max<subject[i]) {
				max = subject[i];
			}
		}
		double total = 0;
		double avg[] = new double[Sc];
		
		for(int i = 0; i<Sc;i++) {	
			avg[i] = subject[i]/max*100;
			total += avg[i];
		}
		System.out.println(total/Sc);
			
			
			
	}
}
