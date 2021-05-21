package nadongbean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class grid3 {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	String item = sc.nextLine();
	
	String result = "";
	List<String> chars = new ArrayList<>();
	int num = 0;
	for(int i = 0; i<item.length();i++) {
		char c = item.charAt(i);
		if(Character.isAlphabetic(c)) {
			chars.add(c+"");
			
			
		}else if(Character.isDefined(c)) {
			num+= c - '0';
		}
	}
	
	Collections.sort(chars);
	
	
	for(int i = 0; i<chars.size();i++) {
		result +=chars.get(i);
	}
	result +=num;

	System.out.println(result);
	
}
}
