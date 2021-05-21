package baekjun1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class baek1110 {
public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int count = 1 ;
	//System.out.println("�Է� �ϼ��� : ");
	String line = br.readLine();
	//System.out.println("�Է¹��� ���� :"+line);
	
	String temp = line;
	if (Integer.parseInt(temp) < 10) {
		temp = "0"+Integer.parseInt(line);
	}
	
	while (true) {
		//System.out.println(count+"ȸ�� �ѹ� : "+temp);
		int first = Integer.parseInt(temp.substring(0,1));
		int second = Integer.parseInt(temp.substring(1));
		int result = first + second;

		String conT;
		if (result <10 ) {
			conT =  "0" + result;
		}else {
			conT =  "" + result;
		}
		
			String Tsecond = conT.substring(1);
			temp = second + Tsecond;
			
		 
		if (Integer.parseInt(temp)==Integer.parseInt(line)) {
			bw.write(count);
			System.out.println(count+"���� �극��ũ");
			break;
		}else {
			count ++;
		}
	}
	
	bw.flush();
	bw.close();
	
}
}