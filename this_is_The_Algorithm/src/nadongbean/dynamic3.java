package nadongbean;

import java.util.Scanner;

public class dynamic3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int x = sc.nextInt();
		int count = 0;
		int[] d = new int[30000];
		
		d[0] = 0;
		d[1] = 0;

		for(int i = 2; i<=x;i++) {
			//현재 수에서 1을 뺴는 경우
			d[i] = d[i-1] +1;
			if(i %2 ==0)d[i] = Math.min(d[i],d[i/2]+1);
			if(i %3 ==0)d[i] = Math.min(d[i],d[i/3]+1);
			if(i %5 ==0)d[i] = Math.min(d[i],d[i/5]+1);
		}
		System.out.println(d[x]);
		
	}
}
