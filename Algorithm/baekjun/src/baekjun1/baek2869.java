package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baek2869 {
	public static void main(String[] args) throws Exception {
		System.out.println("start");
		long beforeTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String[] items = br.readLine().split(" ");
		int days;
		
		int A = Integer.parseInt(items[0]); // speed of hiking
		int B = Integer.parseInt(items[1]); // speed of sliding
		int V = Integer.parseInt(items[2]); // total distance
		
		days = ((V-B-1)/(A-B))+1;
		bw.write(days+"");
		System.out.println("--------------");
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("end(m) : "+secDiffTime);
		bw.flush();
		bw.close();
		
	}
}
