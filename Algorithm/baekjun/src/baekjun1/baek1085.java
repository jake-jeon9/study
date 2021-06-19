package baekjun1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer item = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(item.nextToken());
		int y = Integer.parseInt(item.nextToken());
		int w = Integer.parseInt(item.nextToken());
		int h = Integer.parseInt(item.nextToken());
		
		int tox1 = Math.abs(x-w);
		int toy1 = Math.abs(y-h);
		int tox2 = Math.abs(0-x);
		int toy2 = Math.abs(0-y);
		int min = 9999;
		int fx =(tox1<=tox2?tox1:tox2);
		int fy =(toy1<=toy2?toy1:toy2); 
		min = fx<=fy?fx:fy;
		System.out.println(min);
		
	}
}
