package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class xthanksgivingday {
	public static void main(String[] args) {
		answer();
	}
	public static void answer() {
		String[] question = { "2016-09-15 01:00:04.001 2.0s","2016-09-15 01:00:07.000 2s"};
		solution(question);
	}	
	public static int solution(String[] lines) {
		int answer = 0;
        int size = lines.length;
        String time[] = new String[size];
        String milly[] = new String[size];
        double st[] = new double[size];
        double et[] = new double[size];
        for ( int i = 0 ; i < size; i++) {
        	String stemp = lines[i].substring(0,23);
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        	Date date;
        	long timestemp;
			try {
				date = sdf.parse(stemp);
				 timestemp= date.getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}

        	time[i] = lines[i].substring(11);
        	System.out.println(time[i]);
        	
        	milly[i] = time[i].substring(13);
        	System.out.println(milly[i]);
        	et[i] = Double.parseDouble(milly[i].replace("s",""));
        	System.out.println(et[i]);
       
        	
        	//���ǰɱ� ���� ��ȭ 
        		
  
       
        	
        }
        
        
        
        

        
        return answer;
    }
	
	
	
	

}
