package baekjun1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class baek2742 {
public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int times = Integer.parseInt(br.readLine());
	for (int i = 0; i < times; i++) {
		bw.write(times-i+"\n");
	}
	bw.flush();
	bw.close();

}
}