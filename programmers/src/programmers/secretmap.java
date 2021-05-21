package programmers;

import java.util.ArrayList;
import java.util.List;

public class secretmap {
public static void main(String[] args) {
	answer();
	
	
}
public static void solution(int n, int[] arr1, int[] arr2) {
    
	List<String> line1 = new ArrayList();
	List<String> line2 = new ArrayList();
	List<String> temper = new ArrayList();
	
	
	for(int round = 0; round<2;round++) {
		int[] arr;
		if(round >0 ) {
			arr = arr2;
		}else {
			 arr = arr1;
		}
		List<String> temp = new ArrayList();
		
	for(int i = 0 ; i<n;i++) {
		int item =arr[i];
		String room = "";
		String getnumber = Integer.toBinaryString(arr[i]);
		String number = "";
		int size = getnumber.length();
		
		for (int start = size ; start<n;start++) {
			 number += "0";
		}
		number +=getnumber;

		//System.out.println(number);
		for(int j = 0 ; j<n;j++) {
			String check = number.substring(j,j+1);
			if(check.equals("1")) {
				room +="#";
			}else {
				room+=" ";
			}
			
		}
		
		temp.add(room);
				
	} 
		if(round >0) {
			line2 = temp;
		}else {
			line1 = temp;	
		}
			

	
   
}

	String answer[] = new String[n];
	for(int item = 0; item<line1.size();item++) {
		String item1 = line1.get(item);
		String item2 = line2.get(item);
		String setNewChar = "";
		for(int j = 0 ; j<n;j++) {
			String check1 = item1.substring(j,j+1);
			String check2 = item2.substring(j,j+1);
			if(check1.equals(" ") &&check2.equals(" ")) {
				setNewChar +=" ";
			}else {
				setNewChar +="#";
			}
			
		}
		answer[item] = setNewChar;                          
		System.out.println(answer[item]);
		
	}
	

		
	
	
}
public static void answer() {
//	int n = 5;
//	int[] arr1 = {9, 20, 28, 18, 11};
//	int[] arr2 = {30, 1, 21, 17, 28};
	int n = 6;
	int[] arr1 = {46, 33, 33 ,22, 31, 50};
	int[] arr2 = {27 ,56, 19, 14, 14, 10};
	solution(n,arr1,arr2);
}
}
