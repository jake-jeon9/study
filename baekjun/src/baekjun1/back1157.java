package baekjun1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class back1157 {
public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String ch = br.readLine();
	String chars[] = ch.split("");
	
	HashMap<String, Object> hash = new HashMap<String, Object>();
	
	List<String> Ch_list = new ArrayList<>();
	
	for (int i = 0 ; i<chars.length;i++) {
		String Char =  chars[i].toUpperCase();
		
		if (!Ch_list.contains(Char)) {
			hash.put(Char, 1);
			Ch_list.add(Char);
		}else {
			int count = (int)hash.get(Char);
			hash.replace(Char, count+1);
		}	
		
	}
	String lastChar="";
	int max=0;
	for(String Chars : Ch_list) {
		int num = (int)hash.get(Chars);
		
		if(max < num) {
			max = num;
			lastChar = Chars;
		}else if(max == num) {
			lastChar = "?";
		}
	}
	
	System.out.println(lastChar);
	
}
}
