package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class back1002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		String result ="";
		for(int i = 0; i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			//형변환int로하면 타입으로 특성으로 인해 손실이 발생하여 다르게 나옴
			double d = Math.sqrt(Math.pow(Math.abs(x2-x1), 2) + Math.pow(Math.abs(y2-y1), 2));
			//case 1 :중점이 같고 반지름도 같은경우
			if(r1-r2==0 && d == 0 ) result += "-1";
			// 점점 2가지 
			else if(Math.abs(r1-r2)<d && Math.abs(r1+r2)>d) result += "2";
			// 접점 1가지
			else if(Math.abs(r1-r2)==d || Math.abs(r1+r2)==d) result += "1";
			// 원안에 다른 원 접점  0  
			else result += "0";
			result+="\n";
		}
		
		bw.write(result);
		bw.flush();
		bw.close();
	}
}
