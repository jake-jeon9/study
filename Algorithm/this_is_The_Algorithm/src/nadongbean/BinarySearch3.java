package nadongbean;

import java.util.Scanner;

public class BinarySearch3 {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	int n = sc.nextInt();
	int target = sc.nextInt();
	int[] arr = new int[n];
	for(int i = 0; i<n;i++) {
		arr[i] = sc.nextInt();
	}
	
	int result = bs(arr,target,0,arr.length);
	System.out.println(result);
	
	
}

public static int bs(int[] arr,int target,int start,int end) {
	
	int result = -1;
	
	while(start<=end){
		int mid =( start + end) /2 ;	
		
		if(arr[mid]==target) {
		int left = 0 ;
		int right = 0;
		//내려가기
		for(int i = mid; i>start;i--) {
			if(arr[i]==target) left =i;
			else break;
		}
		//올라가기
		for(int i = mid; i<end;i++) {
			if(arr[i]==target) right =i;
			else break;
		}
		System.out.println("R : "+ right+" / L:"+left);
		result = right - left + 1;
		break;

		}
		
		if(arr[start]<target) start +=1;
		else if(arr[end] > target) end -=1;
				
	}
	
	

	return result;
}
}
