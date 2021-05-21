package nadongbean;

import java.util.Scanner;

public class dynamic2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] k = new int[n];
		int[] list = new int[100];
		
		for(int i = 0; i< n;i++) {
			k[i] = sc.nextInt();
		
		}
		int result = 0;
		
		list[0] = k[0];
		list[1] = Math.max(k[0], k[1]);
		
		for(int i =2;i<n;i++) {
			list[i] = Math.max(k[i-1],k[i-2]+k[i]);
		}
		System.out.println(list[n-1]);
 	}
	

}
