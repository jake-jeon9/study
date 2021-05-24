package baekjun1;

public class Xbaek4673 {
public static void main(String[] args) {

	
	boolean[] check = new boolean[10001];
	for(int i = 1 ; i<10001;i++) {
		int n = f(i);
		
		if(n<10001) {
			check[n] = true;
		}
	}
s
	StringBuilder sb = new StringBuilder();
	
	for(int i = 1; i<10001;i++) {
		if(!check[i]) {
			sb.append(i).append("\n");
		}
	}
	System.out.println(sb);
}

static int f(int n) {
	
	int sum = n;
	
	while(n != 0) {
		sum +=(n%10); // ������ 1���ڸ��� ���ܵ�
		n = n/10; // ���� ���ڸ� 1/10 ���� ���� �ٽ� ���ư� 
		
	}
	return sum;
	
	
}
	
}
