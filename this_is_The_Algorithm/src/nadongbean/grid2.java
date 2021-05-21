package nadongbean;

import java.util.Scanner;

public class grid2 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	String item = sc.nextLine();

	int result = 0;
	

	int cols =item.charAt(0) - 'a' +1;
	int rows = item.charAt(1) - '0';
	//방향 벡터 dx,dy
	int[] move2 = {2,-2,2,-2};
	int[] move1 = {1,-1};
	
	System.out.println("x : "+ rows+", y :"+cols);
	for(int CASE = 0; CASE<4;CASE++) {
		
		for(int CASE2 = 0; CASE2<2;CASE2++) {
			System.out.println("--------------");
			int col= cols;
			int row= rows;
			
			if(CASE<2) { //x축기준
				row= rows +move2[CASE];
				col= cols + move1[CASE2];
				
			}else { // y축 기준
				col= cols + move2[CASE];
				row= rows +move1[CASE2];
			}
			System.out.println("row : "+row+", col : "+col);

			if(col>0&&col<9&&row>0&&row<9) {
				result++;
				System.out.println("결과 증가");
			}
			System.out.println(CASE + " 결과 : " +result);
		}

	}
	
	//동빈이 풀이
	int[] dx = {-2, -1,1,2,2,1,-1,-2};
	int[] dy = {-1,-2,-2,-1,1,2,2,1};
	
	for(int i = 0; i<8;i++) {
		int nextRow = rows+dx[i];
		int nextCol = cols + dy[i];
		if(nextRow>=1 &&nextRow <=8 &&nextCol>=1&&nextCol<=8) {
			result =+1;
		}
	}
		
	
	
		
	System.out.println(result);
			
			
			
}
}
