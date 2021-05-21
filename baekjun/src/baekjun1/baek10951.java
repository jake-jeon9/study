package baekjun1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class baek10951{
public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	String input;
	
		while(true) {
			if ((input = br.readLine()) == null) break;
		StringTokenizer st = new StringTokenizer(input);
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		bw.write(x+y+"\n");
		
		//bw.newLine();
	}
	bw.flush();
	bw.close();
	

}
}