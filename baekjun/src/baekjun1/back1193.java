package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class back1193 {
public static void main(String[] args) throws NumberFormatException, IOException {
	System.out.println("���� ����");
	long beforeTime = System.currentTimeMillis();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int index = Integer.parseInt(br.readLine());
	
	int lineNumber = 1;
	int positionNumber = 1;
	
	int x,y =0;
	
	while(true) { 
//		System.out.println("line? "+lineNumber);
//		System.out.println("pn?" + positionNumber);
		if(index<=positionNumber) {
			y = index-(positionNumber-lineNumber);
			x = lineNumber - y +1;
			if(lineNumber%2==0) { //¦�� �Ʒ��� ��				
				bw.write(y+"/"+x);
				
			}else { // Ȧ��  ������ �Ʒ�
				bw.write(x+"/"+y);
			}
			break;
		}else {
			lineNumber++;
			positionNumber += lineNumber;
			
		}
	
	}
	
	System.out.println("--------------");
	long afterTime = System.currentTimeMillis(); 
	long secDiffTime = (afterTime - beforeTime);
	System.out.println("���� ����(m) : "+secDiffTime);
	bw.flush();
	bw.close();
	
	
}
}
