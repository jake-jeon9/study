package dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class B10828_A {
	public static void main(String[] args) throws Exception {
		Stack<Integer> s = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int r = Integer.parseInt(br.readLine());
		String result = "";
		for(int i = 0; i<r;i++) {
			String order = br.readLine();
			if (order.startsWith("push")) {
				int num = Integer.parseInt(order.replace("push ",""));
				s.push(num);
			}else if(order.startsWith("top")) {
				result +=(s.size()>0 ?s.peek():-1)+"\n";
			}else if(order.startsWith("empty")) {
				result +=(s.size() == 0 ? 1:0) +"\n";
			}else if(order.startsWith("size")) {
				result += s.size()+"\n";
			}else if(order.startsWith("pop")) {
				result +=( s.size()>0 ? s.pop():-1)+"\n";
			}
		}
		
		bw.write(result);
		bw.flush();
		bw.close();

	}
}
