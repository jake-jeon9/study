package nadongbean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class sorting1 {
	

	
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int k = sc.nextInt();
	sc.nextLine();//���� ����
	List<Integer> A = new ArrayList<>();
	List<Integer> B = new ArrayList<>();
	//2���� ����Ʈ�� �� ���� �Է¹ޱ�
	for(int i = 0; i<2;i++) {
		String[] item = sc.nextLine().split(" ");
		for(int j = 0 ; j<item.length;j++) {
			if(i==0) {
				A.add(Integer.parseInt(item[j]));
			}else {
				B.add(Integer.parseInt(item[j]));
				
			}
		}	
	}
	Integer[] a = new Integer[n];
	for(int i =0;i<n;i++) {
		a[i] = sc.nextInt();
	}
	Integer[] b = new Integer[n];
	for(int i =0;i<n;i++) {
		b[i] = sc.nextInt();
	}
	
	Arrays.sort(a); // �������� ����
	Arrays.sort(b,Collections.reverseOrder()); // �������� ���� 
	
	for(int i =0 ; i<k;i++) {
		if(a[i]<b[i]) {
			int temp = a[i];
			a[i] = b[i];
			b[i] = temp;
		}else break;
		
	}
	

	Collections.sort(A);
	Collections.sort(B);

	for(int i = 0; i<k;i++) {
		A.set(i, B.get(n-i-1));
	}
	
	int sum = 0;
	for(int i = 0; i<A.size();i++) {
		sum+=A.get(i);
	}
	System.out.println(sum);
	
	
}
}
