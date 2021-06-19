package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B1978 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result = 0;
		int n = Integer.parseInt(br.readLine());
		String items = br.readLine();
		String[] item = items.split(" ");
		for(int i = 0; i<n;i++) {
			int target = Integer.parseInt(item[i]);
			
			if(target <2) {
				continue;
			}else if(target == 2) {
				result ++;
				continue;
			}else {
				boolean check = true;
				for(int j = 2; j<=Math.sqrt(target);j++) {
					if(target % j == 0) {
						check = false;
						break;
					}
				}
				if(check) result ++;
			}
			
		}
		System.out.println(result);
		
	}
}
/*
for(int j = 2; j<Math.sqrt(target);j++) {
	if(target % j == 0) {
		break;
	}
}

			if(target <2) {
				continue;
			}else if(target == 2 || target ==3 || target == 5 || target == 7) {
				result ++;
				continue;
			}else if(target %2 == 0||target %3 == 0 || target % 5 == 0||target %7 ==0){
				continue;
			}else {
				result ++;
			}

*/
