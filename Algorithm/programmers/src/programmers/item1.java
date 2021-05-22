package programmers;

public class item1 {
	public static void main(String[] args) {
		
		String s = "1234";
		System.out.println(solution(s));
		
	}
	
	public static int solution(String s) {
		int answer = 0;
	   char item  = s.charAt(0);
        if(Character.isDefined(item)){
            answer = Integer.parseInt(s);
        }else{
            String number = s.substring(1);
            answer = Integer.parseInt(number);
            if(item == '-'){
              answer *=-1;
            }
        }
		return answer;
	}
}

