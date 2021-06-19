package programmers;

import java.util.*;
public class item77484 {
	public static void main(String[] args) {
		int[] lottos = {41, 42, 43, 44, 45, 40};
		int[] win_nums = {1, 2, 3, 4, 5, 6};
		int[] result = solution(lottos,win_nums);
		System.out.println(result[0]+","+result[1]);
	}
	
	
	 public static int[] solution(int[] lottos, int[] win_nums) {
		 int[] answer = {};
		 
		 int result = 0;
		 int zero = 0;
		 for(int i = 0; i<6;i++) {
			 if(lottos[i] == 0 ) {
				 zero ++;
				 continue;
			 }
			 for(int j = 0; j<6;j++) {
				 if(lottos[i]==win_nums[j]) {
					 result++;
					 break;
				 }
			 }
		 }
		 answer= new int[2];
		 answer[0] = result==0&&zero == 0? 6:(7 - (result+zero));
		 answer[1] = result > 0 ? (7 -  result ) : 6;
		 
//		 answer[0] = Math.min(7-(result+zero), 6);
//		 answer[1] = Math.min(7-result, 6);
		 
		 return answer;
	 }
}
/*
  return LongStream.of(
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
        )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
                
                 int cnt1 = 0;
        int cnt2 = 0;
        for(int i : lottos) {
            if(i == 0) {
                cnt1++;
                continue;
            }
            for(int j : win_nums) {
                if(i == j) cnt2++;
            }
        }


        answer[0] = getGrade(cnt1+cnt2);
        answer[1] = getGrade(cnt2);

        return answer;
    }

    public int getGrade(int n) {
        switch(n) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default :
                return 6;
        }
    }
 */
