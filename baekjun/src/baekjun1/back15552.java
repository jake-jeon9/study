package baekjun1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class back15552 {
public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int times = Integer.parseInt(br.readLine());
	for (int i = 0; i < times; i++) {
		String[] strs = br.readLine().split(" ");
		int x = Integer.parseInt(strs[0]);
		int y = Integer.parseInt(strs[1]);
		bw.write(x+y+"\n");
		//bw.newLine();
	}
	bw.flush();
	bw.close();
	
	
	/*
	 String str = br.readLine();
	 int i = Integer.parseInt(br.readLine());
	 String arr[] = str.split(" ");

	 bw.write(str);
	 bw.newLine();
	 bw.flush();
	 bw.close();
	 */

}
}