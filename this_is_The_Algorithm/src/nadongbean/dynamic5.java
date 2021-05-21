package nadongbean;

import java.util.Arrays;
import java.util.Scanner;

public class dynamic5 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] table = new int[20][20];
		int[] rows = new int[t];
		int[] cols = new int[t];

		String[] str = new String[t];
		int[] answer = new int[t];
		for(int i = 0 ; i< t; i++) {
			
			cols[i] = sc.nextInt();
			rows[i] = sc.nextInt();
			sc.nextLine();
			str[i] = sc.nextLine();
		
		}
		
		for(int i = 0; i<t;i++) {

			String[] temp = str[i].split(" ");
			int cnt =0;
			for(int col = 0;col<cols[i];col++) {
				for(int row = 0; row<rows[i];row++) {
				table[col][row] = Integer.parseInt(temp[cnt]);	
					cnt++;
				}
				
			}
			
			for(int row = 0;row<rows[i];row++){
				int max = 0;
				for(int col = 0 ;col<cols[i];col++) {
					max = Math.max(max, table[col][row]);
					
				}
				System.out.println((row+1)+"ÀÇ max>? "+max);
				answer[i]+=max;
			}
			
			
			System.out.println(answer[i]);

		}

	}
	
}
