package nadongbean;

import java.util.Scanner;

public class grid {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int count = 0;
		
		for(int i = 0 ; i<=n;i++) {
//			//�밡�� Ǯ��
//			if(i%10==3) {
//				count+=3600;
//				
//			}else {
//				for(int mm = 0; mm<60;mm++) { // ���ǽð�
//					if( mm%10==3||mm/10==3) {
//						count+=60;
//					}else {
//						for(int ss =0; ss<60;ss++) { //���� �ð�
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
//			���� ������ Ǯ��
			
			if(i%10==3) {
				count += 3600;
			}else {
				//���� 3�ʴܵ�
				int ss = 6;
				//�ź� 3X ���� (33�� ����)
				int ts = 10-1;
				//3���Ǵ���
				int m3 = 60*6;
				//30���϶� 
				int tm = 9*60; // 33������  
				
				//�ð��� 3�� �� ����
				int totalM = (ss+ts) * (60-(9+6));//�� 3�д��� 6��/ 30�д��� 10-1 ��
				System.out.println(totalM);
				count +=(totalM+m3+tm);
				
			}

		}
		System.out.println(count);
		
	}
}
