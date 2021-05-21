package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baek10250 {
	public static void main(String[] args) throws Exception{
		System.out.println("���� ����");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long beforeTime = System.currentTimeMillis();	
		

		int index = Integer.parseInt(br.readLine());
		String item[] = new String[index];
		for(int i = 0; i<index; i++) {
			item[i]= br.readLine();		
		}

		for(int i =0;i<index;i++) {
			String[] items = item[i].split(" ");
			int H = Integer.parseInt(items[0]);
			int W = Integer.parseInt(items[1]);
			int guest = Integer.parseInt(items[2]);
			int count = 0;
			String room;
			for(int w =1;w<=W;w++) {
				for(int h = 1;h<=H;h++) {
					count++;
					if(count == guest) {
						if(w<10) {
							room = h+"0"+w;	
						}else {
							room = h+""+w;
						}
						System.out.println(room);
						
						break;
						
					}
				}
			}

			
		}
		
		

		bw.flush();
		bw.close();
		System.out.println("--------------");
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("���� ����(m) : "+secDiffTime);
		
	}


}
