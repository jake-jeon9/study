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
		Arrays.fill(index,m+1); // 특정값으로 초기화
		
		
		index[0] = 0;
		
		for(int i = 0;i<n;i++) { //화폐 종류만큼 반복
			
			for(int j = mt[i];j<=m;j++) { // 화폐 값을 j에 넣어서 확인
				
				//(i-k)원을 만드는 방법이 존재하는 경우
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
