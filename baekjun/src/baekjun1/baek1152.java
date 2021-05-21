package baekjun1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baek1152 {
public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String strs[] = br.readLine().trim().split(" ");
	
	if (strs[0].equals(" ") || strs[0].equals("")) {
		System.out.println("0");
	}else {
		System.out.println(strs.length);	
	}
	
	
}
}
