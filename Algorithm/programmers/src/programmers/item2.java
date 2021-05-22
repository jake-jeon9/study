package programmers;

public class item2 {
	public static void main(String[] args) {
		String s = "AB";
		String k = "z";
		String w = "a K c";
		int s1 = 1;
		int k1 = 3;
		int w1 = 3;
		System.out.println(solution(w,w1));	
	}

	private static String solution(String s,int n) {
		String answer = "";
		System.out.println("전달받음 : "+s+", "+n);
		 char[] item = new char[s.length()];
	        
	        for(int i = 0; i<s.length();i++){
	            item[i] = s.charAt(i);
	            if(item[i] == ' '){
	            	answer += " ";
	            	continue;
	            }
	            char comp = 'z'; // 소문자
	            char comp1 = 'a';
            	if(item[i]-'a' <0) {
            		//대문자
            		comp ='Z'; 
            		comp1 = 'A';
            		System.out.println("대문자 체크");
            	}
        		int check = (item[i] + n);
        		char temp ='z';
        		if(check-comp>=0) {
        			System.out.println("z초과");
        			temp = (char)(check-comp+comp1-1);
        		}else {
        			temp = (char)check;
        		}
        		answer += temp;	
            	
	                
	        }

		return answer;
	}
}
