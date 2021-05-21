package baekjun1;

import java.util.Scanner;

public class baek1065 {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	int num = sc.nextInt();
	int index = caller(num);
	System.out.println(index);
	sc.close();
}

static int caller(int num) {
	int hund,ten,one,cnt = 0;
	if(num<100) {
		return num;
	}else {
		for(int i = 100;i<=num;i++) {
			hund = i/100;
			ten = (i%100)/10;
			one = (i%10);
			
			if((hund+one)==(2*ten)) {
				cnt++;
				//System.out.println(i+"�� (hund-ten)==(ten-one) ��");
			}
			
		}
		return (99+cnt);
	}
		
}
}
