package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class baek2292 {
	public static void main(String[] args) throws IOException {
		System.out.println("���� ����");
		long beforeTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int index = Integer.parseInt(br.readLine());
		int count = 0;
		int lastnum = 0;
		List<Integer> list = new ArrayList<>();
		while(lastnum<=1000000000) {
			if( count >0) {
				int item =list.get(count-1)+(6*count); 
				list.add(item);
			}else if(count == 0) {
				list.add(1);
			}
			lastnum = list.get(count);
			count ++;
		}
		
		int lineNum = 0;
		int counter = 1;
		System.out.println("index : "+index);
		System.out.println("--------------");
		while(true) {
			if(index>=list.get(counter-1)&&index<=list.get(counter)) {
				System.out.println("���� �ѹ� : "+list.get(counter-1));
				System.out.println("���� �ѹ� : "+list.get(counter));
				if(index==list.get(counter-1)) {
					lineNum = counter;
					System.out.println("����");
				}else {
					lineNum = counter+1;	
				}
				
				break;
			}else {
				counter++;
			}
			
		}
		System.out.println("--------------");
		System.out.println(lineNum);
	
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("���� ����(m) : "+secDiffTime);
		
	}
}