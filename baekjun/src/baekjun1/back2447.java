package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class back2447 {
	static char[][] stars;
	public static void main(String[] args) throws Exception{
//		System.out.println("���� ����");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		//StringTokenizer st = new StringTokenizer(br.readLine());
		long beforeTime = System.currentTimeMillis();
		String item1 = br.readLine();
		int index = Integer.parseInt(item1);;
		

		stars = new char[index][index];
		int round = 1;
		int count = 1;
		for(int i = 1;i<index/3;i++) {
			count *=3;
			if(count!=index) {
				round++;
				continue;
			}else {
				break;
			}
			
			
		}
		for(int out = 1; out<=index;out++) {	
			for(int inner = 1; inner <= index; inner++) {
				stars[inner-1][out-1] ='*';
			}
			
		}	
		int cal = 1;
		for(int i = 1;i<=round;i++) {
			cal *=3;
			for(int out = 1; out<=index;out++) {	
				for(int inner = 1; inner <= index; inner++) {
					putStar(inner,out,cal,index);
				}
				
			}	
		}
		

		String item = "";
		for(int i = 0; i<index;i++) {
			for(int j = 0; j < index; j++) {
				item+=stars[i][j];
			}
			item+="\n";
		}
		bw.write(item);
		System.out.println("--------------");
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("���� ����(m) : "+secDiffTime);
		
		bw.flush();
		bw.close();

		
	}
	
	static void putStar(int row, int col,int round,int index) {
		
		int addpoint = round/3;
		int mincp = round/2+1;
		int maxcp = round/2+1;
		if( addpoint%3==0) {
			mincp -= addpoint/2;
			maxcp += addpoint/2;	
		}
		int isRow = (row)%3;
		int isCol = (col)%3;

		if(isRow==2&&isCol==2) {
			stars[row-1][col-1] =' ';
		}else if((mincp%round<=row%round && row%round<=maxcp%round)&&(mincp%round<=col%round && col%round<=maxcp%round)) {
			stars[row-1][col-1] =' ';
		}
		
	}

}
