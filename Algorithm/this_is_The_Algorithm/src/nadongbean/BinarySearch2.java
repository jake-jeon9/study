package nadongbean;

import java.io.IOException;
import java.util.Scanner;

public class BinarySearch2 {
	
	
public static void main(String[] args) throws NumberFormatException, IOException {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();	

	int[] arr = new int[n]; 
	for ( int i = 0; i<n; i++) {
		arr[i] = sc.nextInt();
	}
	
	//����Ž���� ���� ���� �� ����
	int start = 0;
	int end = (int)1e9;
	int result = 0;
	//����Ž��
	while(start<=end) {
		long total = 0;
		int mid = (start +end ) / 2;
		
		for(int i= 0; i<n;i++) {
			if(arr[i]>mid) total += arr[i]-m;
		}
		if(total<m) end = mid -1;
		else {
			result = mid;
			start = start+1;
		}
		
	}
		System.out.println(result);
	
}



}