package nadongbean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class updownLR {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("���� ����");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long beforeTime = System.currentTimeMillis();
		// ����
		int index = Integer.parseInt(br.readLine());
		String items = br.readLine();
		String[] item = items.split(" ");
		String[] plan = {"L","R","U","D"};
		//��õ���
		//L R U D ���߱�
		int[] dx = {0, 0 , -1,1};
		int[] dy = {-1,1,0,0 } ;
		
		int x =1 , y = 1;
		
		for(int j = 0; j<items.length();j++) {
			int nx = -1, ny = -1;
			for(int i = 0; i< dx.length;i++) {
				if(item[j].equals(plan[i])) {
					nx = x + dx[i];
					ny = y + dy[i];
				}
				
			}
			//������ ����� ��� ����
			if(nx< 1 || ny < 1 || nx>index || ny>index) continue;
			
			y = ny;
			x = nx;
			
		}
		
		
		
		//���� �ϴ� ���
		int cx = 1,cy = 1;
		for(int i = 0; i< items.length();i++) {
			switch (item[i]) {
			case "R":
				if(cx<index) cx +=1;		
				break;
			case "L":
				if(cx != 1)	cx -=1;
				break;
			case "U":
				if(cy==1) cy-=1;
				break;
			case "D":
					if(cx<index) cy+=1;
				break;
						
			}
			
		}
		
		
		
		bw.write(cx+","+cy);
		bw.flush();
		bw.close();
		System.out.println("--------------");
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("���� ����(m) : "+secDiffTime);
		
	}


}
