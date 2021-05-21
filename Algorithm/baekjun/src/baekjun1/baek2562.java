package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baek2562 {
public static void main(String[] args) throws IOException{
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int item[] = new int[9];
	
	for (int i = 0;i<9;i++) {
		item[i] = Integer.parseInt(br.readLine());	
	}
	
	
	int where=1;
	int max = item[0];
	
	for ( int i = 1; i<item.length;i++) {
		if( max< item[i]) {
			max = item[i];
			where =i+1;
		}
	}
	bw.write(max+"\n"+where);
	bw.flush();
	bw.close();
}
}
