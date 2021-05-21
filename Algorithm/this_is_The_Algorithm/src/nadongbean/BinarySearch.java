package nadongbean;

import java.util.Scanner;

public class BinarySearch {
	
	//이진 탐색 소스코드 구현(반복문)
	public static int binarySearch(int[] arr,int target,int start,int end){
		while(start <= end){
			int mid = (start + end) / 2;
	
			//타켓이 미드이면 그대로 종료
			if(arr[mid]==target) {
				return mid;
				//중간값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
			}else if(arr[mid]>target) {
				end = mid -1;
				//중간값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
			}else {
				start = mid +1;
			}

		}
		return -1;
	}

public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	int n = sc.nextInt();
	int target = sc.nextInt();
	
	//전체 원소 입력 받기
	int[] arr = new int[n]; 
	
	for(int i = 0; i<n;i++) {
		arr[i] = sc.nextInt();
		
	}
	
	//이진 탐색 수행 결과 출력
	int result = binarySearch(arr, target, 0,n-1);
	
	if(result == -1) {
		System.out.println("찾고자하는 값이 없음");
	}else {
		System.out.println(result+1);
	}
	
}
}
