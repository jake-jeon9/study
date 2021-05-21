package programmers;

import java.util.ArrayList;
import java.util.List;

public class rateOfFail {
public static void main(String[] args) {
	int n = 5;
	int[] answer = new int[n];
	int[] stages = solution();
	
	List<Integer> list = new ArrayList<>();
	List<Double> data = new ArrayList<>();
	for(int round = 1; round<=stages.length;round++) {
		list.add(stages[round-1]);
	}
	for(int round = 1; round<=n;round++) {
		int oriSize = list.size();
		if(list.contains(round)) {
			int count = 0,i=0;
			while(list.contains(round)) {

				int num = list.get(i);
				if(num==round) {
					list.remove(i);
					count++;
					i= -1 ;
				}
				i++;
			}
			if( count != 0) {
				String key = round + "";
				double value = 1.0*count/oriSize;
				data.add(value);
				System.out.println(round+"스테이지 : "+count+"/"+oriSize);
			}
			
		}else {
			System.out.println(round+"스테이지 : "+0);
			String key = round + "";
			data.add(0.0);
		}
	}
	
	list.clear();
	for(int i = 0; i<data.size()-1;i++){
		for(int j = 1; i<data.size();i++){
			if(data.get(i)<data.get(j)){
			
			}
		}
	}

	
	

	
}

static int[] solution() {
    int[] answer = {2, 1, 2, 6, 2, 4, 3, 3};
    return answer;
}


}
