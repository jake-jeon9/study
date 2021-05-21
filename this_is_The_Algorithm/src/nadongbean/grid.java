package nadongbean;

import java.util.Scanner;

public class grid {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int count = 0;
		
		for(int i = 0 ; i<=n;i++) {
//			//노가다 풀이
//			if(i%10==3) {
//				count+=3600;
//				
//			}else {
//				for(int mm = 0; mm<60;mm++) { // 분의시간
//					if( mm%10==3||mm/10==3) {
//						count+=60;
//					}else {
//						for(int ss =0; ss<60;ss++) { //초의 시간
//							if(ss%10==3||ss/10==3) {
//								
//								count++;
//							}
//							
//						}	
//					}
//					
//				}
//				
//			}
//		
//			내가 생각한 풀이
			
			if(i%10==3) {
				count += 3600;
			}else {
				//매초 3초단뒤
				int ss = 6;
				//매분 3X 단위 (33초 제외)
				int ts = 10-1;
				//3분의단위
				int m3 = 60*6;
				//30분일때 
				int tm = 9*60; // 33분제외  
				
				//시간당 3이 들어간 갯수
				int totalM = (ss+ts) * (60-(9+6));//매 3분단위 6개/ 30분단위 10-1 개
				System.out.println(totalM);
				count +=(totalM+m3+tm);
				
			}

		}
		System.out.println(count);
		
	}
}
