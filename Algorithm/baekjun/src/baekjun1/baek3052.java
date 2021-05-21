package baekjun1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baek3052 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(int i = 0; i<10; i++) {
			int num= Integer.parseInt(br.readLine());
			list2.add(num%42);
		}
		for(int data : list2) {
			if(!list.contains(data)) {
				list.add(data);
			}
		}
		System.out.println(list.size());

		
		
	}

}
