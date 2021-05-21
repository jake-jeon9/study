package sample4;

import java.util.Calendar;

//추상클래스
//=> 싱글톤 패턴으로 작성
abstract public class AbstractTest {
	
	abstract public String dayInfo();
	
	public static AbstractTest getInstance() {
		
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_WEEK); 
		//요일 수 구하기 : 오늘이 1주일중 몇번째 일인지 나타내는 값 
		
		switch(day) {
		case 1: return new Sunday();
		case 2: return new Monday();
		case 3: return new Tuesday();
		case 4: return new Wednesday();
		case 5: return new Thursday();
		case 6: return new Friday();
		case 7: return new Saturday();
		
		}
		return null;
	}
}
