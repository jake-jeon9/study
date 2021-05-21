package kakao2018A;

public class kakako2 {
	static int lastnum = 0;
public static void main(String[] args) {
	int n = 6; 
	int[] passenger = {1,1,1,1,1,1} ; 
	int[][] train = {{1,2},{1,3},{1,4},{3,5},{3,6}};
	int[] inf = new int[3];
	int bt = 0;
	for(int i =0; i<train.length;i++) {		
		
		int ct = 0;

			int a = train[i][0];
			int b = train[i][1]; 
			System.out.println("1번역은" + a);
			System.out.println("2번역은" + b);
			int ga = passenger[a-1];
			int gb = passenger[b-1];
			
			int getSum = getinf(b,0);
			int sum = ga+gb+getSum;
		System.out.println("돌려받은값 : "+ getSum);
			ct = ga + gb+sum;

			
			if( bt <= ct) {
				System.out.println();
				bt = ct;
				inf[0] = a;
				inf[1] = b;
				inf[2] = bt;
			
		}
	}
	
	

	System.out.println(inf[1]+","+inf[2]);
	
	
	
	
	
}
static int getinf(int b,int last) {
	int[] passenger = {1,1,1,1,1,1} ; 
	int[][] train = {{1,2},{1,3},{1,4},{3,5},{3,6}};
	int ct = 0;
	int linecheck = 0;
	for(int i = b; i<train.length;i++) {
		
		int bs = train[i][0];
		int as = train[i][1];
		if(i == as) continue;
		if(b==bs) {
				System.out.println(b+"연결된 맵"+as);
				if(passenger[as-1]<=ct) ct=passenger[as-1];
				return getinf(as,as);
			}else {
				System.out.println(b+"연결된 맵"+as);
				if(passenger[as-1]<=ct) ct=passenger[as-1];
				lastnum = as;
				return ct + getinf(as,as);	
			}

			
		
	
	}
	System.out.println("리턴값" +ct);
	return ct;
	

	
}



}
