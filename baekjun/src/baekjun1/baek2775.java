package baekjun1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baek2775 {
	public static void main(String[] args) throws Exception{
		System.out.println("���� ����");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		long beforeTime = System.currentTimeMillis();	
		int index = Integer.parseInt(br.readLine());

		for(int round = 0 ; round<index;round++) {
			int row = Integer.parseInt(br.readLine());
			int col = Integer.parseInt(br.readLine());
			int[][] room = new int[row+1][col+1];
			
			for(int ROW = 1;ROW<=row;ROW++) {
				room[ROW][1] = 1;
			}
			for(int COL = 1;COL<=col;COL++) {
				room[0][COL] = COL;
			}
			
			boolean isDone = false;
			for(int ROW = 1;ROW<=row;ROW++) { //1������
				for(int COL = 2;COL<=col;COL++) { //2ȣ ���κ���
					System.out.println("ȣ�� : "+ROW+"��"+COL+"ȣ");
					room[ROW][COL] = room[ROW-1][COL] + room[ROW][COL-1];
					System.out.println(room[ROW][COL]);
				}
				isDone = true;
			}
			if(isDone) {
				System.out.println("----��----");
				System.out.println(room[row][col] );	
			}
			
			
		}
		
		

		
		//bw.write(index + "");
		bw.flush();
		bw.close();
		System.out.println("--------------");
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("���� ����(m) : "+secDiffTime);

	}
	


}
/*
 * 
 * 
		
		int[][] room = new int[15][15];
		for(int i = 0 ; i<15;i++) {
			room[i][1] = 1; // 1ȣ����
			room[0][i]= i; // �� �Ʒ��� 
		}
		
		for(int ROW = 1; ROW< 15; ROW++) { //1 ������
			for(int COL = 2; COL<15;COL++) { //2ȣ ����
				room[ROW][COL] = room[ROW][COL-1]+room[ROW-1][COL];
				
			}
			
		}
		int index = Integer.parseInt(br.readLine());
		
		for(int round = 0; round<index; round++) {
			int row = Integer.parseInt(br.readLine());
			int col = Integer.parseInt(br.readLine());
			
			System.out.println(room[row][col]);
		}
 * 
 * 
 * */
 