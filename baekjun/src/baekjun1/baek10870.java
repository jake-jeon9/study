package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baek10870 {
	public static void main(String[] args) throws Exception{
		System.out.println("���� ����");
		long beforeTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int index = Integer.parseInt(br.readLine());
		
		int result =f(index); 
		
		
		
		bw.write(result+"");
		bw.flush();
		bw.close();
		System.out.println("--------------");
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("���� ����(m) : "+secDiffTime);
		
	}

	static int f(int num) {
		if(num ==0) {
			return 0;
		}else if(num == 1 ) {
			return 1;
		}else {
			return  f(num-1)+f(num-2);
		}
	}

}
