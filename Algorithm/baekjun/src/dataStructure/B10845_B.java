package dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class B10845_B {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue s = new LinkedList();
		int lastNum = -1;
		String result = "";
		int r = Integer.parseInt(br.readLine());
		for(int i = 0; i<r;i++) {
			String order = br.readLine();
			
			if (order.startsWith("push")) {
				lastNum = Integer.parseInt(order.replace("push ", ""));
				s.offer(lastNum);
			}else if(order.startsWith("front")) {
				result +=((s.size()>0?s.peek():-1) +"\n");
			}else if(order.startsWith("empty")) {
				result += ((s.isEmpty()==true?1:0 )+ "\n");
			}else if(order.startsWith("size")) {
				result += (s.size()+ "\n");
			}else if(order.startsWith("pop")) {
				result += ((s.size() > 0 ?s.poll():-1) +"\n");
			}else if(order.startsWith("back")) {
				result += ((s.size()>0?lastNum:-1) + "\n");
			}
			
		}
		bw.write(result);
		bw.flush();
		bw.close();
	}
	
}
