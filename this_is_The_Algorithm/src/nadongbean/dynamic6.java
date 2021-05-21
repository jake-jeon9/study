package nadongbean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class dynamic6 {
	static int n ;
	static ArrayList<Integer> v = new ArrayList<>();
	static int[] d = new int[2000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		 n = sc.nextInt();
		
		
		
		for(int i=n;i>0;i--) {
			v.add(sc.nextInt());
		}
		Collections.reverse(v);
		
		//���̳��� ���α׷����� ���� 1���� dp���̺� �ʱ�ȭ
		for(int i=0;i<=n;i++) d[i] = 1;
		
		//���� �� �����ϴ� �κ� ���� �˰��� ����
		for(int i=1;i<n;i++) {
			for(int j =0; j<i;j++) {
				if( v.get(j)<v.get(i)) {
					d[i] = Math.max(d[i],d[j]+1);
				}
			}
			
		}
		int max=0;
		for(int i = 0;i<n;i++) {
			max = Math.max(max, d[i]);
		}
		System.out.println(n-max);
		
		
		
	}
}
