package baekjun1;
import java.io.IOException;
import java.util.Scanner;

public class baek5 {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	int hh = sc.nextInt();
	int mm = sc.nextInt();
	
	if(hh==0 && mm < 45) {
		hh = 23;
		mm = mm-45 + 60;
	}else if(hh>0&& mm < 45) {
		hh -=1 ;
		mm = mm-45 + 60;
	}else {
		mm -= 45;
	}
	
	
	
	System.out.println(String.format("%d %d", hh,mm));
	
	
	
}
	
}


