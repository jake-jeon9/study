package dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10845_A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int lastNum = -1;
		int r = Integer.parseInt(br.readLine());
		Queue1 s = new Queue1(r);
		String result = "";
		for(int i = 0; i<r;i++) {
			String order = br.readLine();
			
			if (order.startsWith("push")) {
				lastNum = Integer.parseInt(order.replace("push ",""));
				s.push(lastNum);
			}else if(order.startsWith("front")) {
				result +=s.front()+"\n";
			}else if(order.startsWith("empty")) {
				result +=(s.isEmpty()==true ? 1: 0)+"\n";
			}else if(order.startsWith("size")) {
				result +=s.size()+"\n";
			}else if(order.startsWith("pop")) {
				result +=s.pop()+"\n";
			}else if(order.startsWith("back")) {
				result +=s.back()+"\n";
			}
			
		}
		bw.write(result);
		bw.flush();
		bw.close();
	}
	
}
class Queue1{
	int frontIndex=0;
	int lastIndex = 0;
	int[] queue;
	Queue1(){};
	Queue1(int size){
		queue = new int[size];
	}
	
	public int size() {
		return lastIndex - frontIndex;
	}
	
	public void push(int item) {
		queue[lastIndex++] = item;
	}
	
	public int pop() {
		if(size() ==0) {
			return -1;
		}else {
			return queue[frontIndex++];
		}
	}
	public boolean isEmpty() {
		if(size() ==0) {
			return true;
		}else {
			return false;
		}
	}
	public int front() {
		if(size() ==0) {
			return -1;
		}else {
			return queue[frontIndex];
		}
	}
	public int back() {
		if(size() ==0) {
			return -1;
		}else {
			return queue[lastIndex-1];
		}
	}
	
	
}
