package kakao2018A;

import java.util.ArrayList;
import java.util.List;

public class kakako {
public static void main(String[] args) {
	int[] gc = {4, 5, 3, 2, 1};
	int[] wants = {2, 4, 4, 5, 1};
//	int[] gc = {5, 4, 5, 4, 5};
//	int[] wants = {1, 2, 3, 5, 4};
	
	List<Integer> list = new ArrayList<>();
	
	
	int checker = 0;
	
	for(int i = 0; i<wants.length;i++) {
		System.out.println(i+"번째 진입");
		for(int j= 0;j<wants.length;j++) {
			if(list.contains(wants[j])) continue;
			
			if(gc[i]==wants[j]) {
				System.out.println("트레이드 전");
				System.out.println(wants[i]+"< -->"+wants[j]);
				checker++;
				int temp = wants[j];
				wants[j] = wants[i];
				wants[j] = temp;
				System.out.println("---후---");
				System.out.println(wants[i]+"< -->"+wants[j]);
				list.add(wants[j]);
				break;
				
			}
			

		}
	}
	
	
	int result = wants.length-checker;
	System.out.println(result);
	
	
	
	
	
}
public int solution() {

    int answer = 0;
    return answer;
}
}
