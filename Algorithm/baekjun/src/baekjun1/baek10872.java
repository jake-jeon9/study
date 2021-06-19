package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Xbaek10872 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("���� ����");
		long beforeTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int index = Integer.parseInt(br.readLine());
		int result = maker(index);

		bw.write(result+"");
		bw.flush();
		bw.close();
		System.out.println("--------------");
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("���� ����(m) : "+secDiffTime);
		
	}
	
	
	static int maker(int num) {
	
		if(num == 0) {
			System.out.println("리턴 1");
			return 1;	
		}else {		
			System.out.println("리턴"+num +"리턴 num-1 : "+(num-1));
			return num  * maker(num-1);
		}
				
	}

}
