package programmers;

public class pro17682 {
	public static void main(String[] args) {
		
		String list[] = {"1S2D*3T","1D2S#10S" , "1D2S0T","10S*2T*3S","1D#2S*3S","1T2D3D#","1D2S3T*"};
		
		for(int i = 0 ; i<list.length;i++) {
			int item = solution(list[i]);
			System.out.println("---------------");
			System.out.println("점수는? "+item);
			System.out.println("---------------");
		}
		
		
	}
	
    public static int solution(String dartResult) {
    	int answer = 0;
    	int score[] = new int[3];
    	int round = 0;
    	boolean isChar = false;
    	int itemSize = dartResult.length();
    	for(int i = 0 ; i<itemSize; i++) {

    		String item = dartResult.substring(i, i+1);
    		int convert = item.charAt(0);
    		int counterS = 0;
    		//System.out.println("convert :" +convert);
    		if(convert>=48 & convert<=57) {//0~9점
    			System.out.println("조건 1 "+(convert<49));
    			System.out.println("조건 2 " + (i>1));
    			System.out.println("조건 3 " + isChar);
    			if(convert<49 && i>0&&isChar) { // 점수 10점
    				System.out.println("십점 진입");
    				String Fitem = dartResult.substring(i-1, i);
    				item = Fitem + item;
    				System.out.println(item);
    				round--;
    			}
        		
    			score[round] = Integer.parseInt(item);
    			round++;
    			isChar = true;
    			System.out.println((round)+"라운드 : "+score[round-1]);
    		}else {
    			System.out.println((round)+"옵션 : "+item);
    			isChar = false;
    			switch (convert) {
    			
    			case 42: //*
    				int times = 2;
    				if(counterS==1) {
    					System.out.println("더블진입");
    					times = 2*2;
    				}else if(convert==2){
    					times = 2*2*2;
    				}
    				if(round>1) {
    					score[round-2] = score[round-2]*times;	
    				}
    				score[round-1] = score[round-1]*times;
    				counterS++;
    				break;
    			case 35://#
    				score[round-1] = 0-score[round-1];
    				break;
	    		case 83 ://S
	    			score[round-1] = score[round-1]; 
	    			break;
	    		case 68://D
	    			score[round-1] = score[round-1]*score[round-1];
	    			break;
	    		case 84://T
	    			score[round-1] = score[round-1]*score[round-1]*score[round-1];
	    			break;
    		    		
        	}
    			System.out.println("현재 점수 : "+score[round-1]);
    		}
    		
    	}
    	for(int Score : score) {
    		System.out.println("라운드 점수 : "+Score);
    		answer+=Score;
    	}
    	return answer;
    }
    	
}
