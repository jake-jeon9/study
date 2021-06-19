package dataStructure;

import java.io.*;
import java.util.*;

public class B10828_B {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int r = Integer.parseInt(br.readLine());
		Stack1 s = new Stack1(r);
		String result = "";
		for(int i = 0; i<r;i++) {
			String order = br.readLine();
			if (order.startsWith("push")) {
				int num = Integer.parseInt(order.replace("push ",""));
				s.push(num);
				//s.push(Integer.parseInt(order.replace("push ", "")));
			}else if(order.startsWith("top")) {
				result +=(s.size()>0 ?s.top():-1)+"\n";
				//bw.write(s.size()>0 ?s.top():-1);
				//System.out.println(s.size()>0 ?s.peek():-1);
			}else if(order.startsWith("empty")) {
				result +=(s.size() == 0 ? 1:0) +"\n";
				//bw.write(s.size() == 0 ? 1:0);
				//System.out.println(s.size() == 0 ? 1:0);
			}else if(order.startsWith("size")) {
				result += s.size()+"\n";
				//bw.write(s.size());
				//System.out.println(s.size());
			}else if(order.startsWith("pop")) {
				result +=( s.size()>0 ? s.pop():-1)+"\n";
				//bw.write(s.size()>0 ? s.pop():-1);
				//System.out.println(s.size()>0 ? s.pop():-1);
			}
		}
		bw.write(result);
		bw.flush();
		bw.close();

	}
	
}
class Stack1{
	private int[] stack;
	private int topIndex = -1;
	Stack1(){};
	Stack1(int number){ // 스텍 사이즈
		stack = new int[number];
	}
	
	public int size() { // 사이즈 리턴
		return topIndex +1;
	}
	public void push(int item) { // 입력
		stack[++topIndex] = item;
	}
	public int top() {
		if(size() == 0) {
			return -1;
		}else {
			return stack[topIndex];	
		}
		
		
	}
	public int pop() {
		if(size() == 0 ) {
			return -1;
		}else {
			return stack[topIndex--];	
		}
		
	}
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
