package baekjun1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class back10952 {
public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	while(true) {
		String[] strs = br.readLine().split(" ");
		int x = Integer.parseInt(strs[0]);
		int y = Integer.parseInt(strs[1]);
		bw.write(x+y+"\n");
		//bw.newLine();
	}
//	bw.flush();
//	bw.close();
	

}
}