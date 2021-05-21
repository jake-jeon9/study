package nadongbean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dynamic4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] item = br.readLine().split(" ");
		int n = Integer.parseInt(item[0]);
		int m = Integer.parseInt(item[1]);
		
		int[] mt = new int[n];
		for(int i= 0 ; i<n;i++) {
			mt[i] = Integer.parseInt(br.readLine());
			
		}
		
		int[] index = new int[m+1];
		Arrays.fill(index,m+1); // Ư�������� �ʱ�ȭ
		
		
		index[0] = 0;
		
		for(int i = 0;i<n;i++) { //ȭ�� ������ŭ �ݺ�
			
			for(int j = mt[i];j<=m;j++) { // ȭ�� ���� j�� �־ Ȯ��
				
				//(i-k)���� ����� ����� �����ϴ� ���
				if(index[j -mt[i]] != m+1) {
					index[j] = Math.min(index[j],index[j-mt[i]]+1);
				}
			}
			
	
			
		}
	
		
		if(index[m]==m+1) {
			System.out.println("-1");
		}else {
			System.out.println(index[m]);
		}
		
		
		
	}
}
