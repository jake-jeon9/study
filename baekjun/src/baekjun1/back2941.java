package baekjun1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class back2941 {
public static void main(String[] args)throws Exception {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String originalString =br.readLine().trim(); 
	String strs[] = originalString.split("");
	
	List<String> list =new ArrayList<String>();
	list.add("c=");
	list.add("c-");
	list.add("dz=");
	list.add("d-");
	list.add("lj");
	list.add("nj");
	list.add("s=");
	list.add("z=");
	int dzcount = 0;
	Pattern pat;
	Matcher match;
	int counter = strs.length;
	if(originalString.equals("")) {
		counter = 0;
	}
	//System.out.println("���ڿ� �Ѽ� : "+counter);
	for(String text :list) {
		pat =Pattern.compile(text);
		match = pat.matcher(originalString);
		//System.out.println("���� ����? : "+text);
		int count = 0;
		while(match.find()) {
			count++;
			if(text.equals("dz=")) {
				dzcount++;
				count++;
			}
		}
		counter -= count;

	}

	
	System.out.println(counter+dzcount);
	
	
}
}

/*
 * if(originalString.equals("dz=")) {
			System.out.println("Ư����ġ");
			counter+=1;
		}
 * 
		if(originalString.contains(text)) {
			
			System.out.println("���� ��ġ");
			if(text.equals("dz=")) {
				System.out.println("Ư�� ���� ��ġ");
				counter -=2;
			}else{
				counter-=1;	
			}
			
		} 
 */


/*
String Char1 = strs[i];

		if (i == strs.length) {
		 
		}
		
		if(strs[i].equals("c")){
			counter ++;
			if(strs[i+1].equals("=")||strs[i+1].equals("-")) {
				counter -=1;
			}
		}else if(strs[i].equals("d")){
			counter ++;
			if(strs[i+1].equals("-")) {
				counter -=1;
			}else if(strs[i+1].equals("z")&&strs[i+2].equals("=")) {
				counter -=2;
			}
		}else if(strs[i].equals("l")) {
			counter ++;
			if(strs[i+1].equals("j")) {
				counter -=1;
			}
			
		}else if(strs[i].equals("n")) {
			counter ++;
			if(strs[i+1].equals("j")) {
				counter -=1;
			}
		}else if(strs[i].equals("s")) {
			counter ++;
			if(strs[i+1].equals("=")) {
				counter -=1;
			}
		}else if(strs[i].equals("z")) {
			counter ++;
			if(strs[i+1].equals("=")) {
				counter -=1;
			}
			
		}else {
			counter ++;
		}

*/