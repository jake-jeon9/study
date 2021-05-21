package nadongbean;

import java.util.Scanner;

public class DFS1 {

	static int[][] visit =new int [1000][1000];
	static int row,col;
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		sc.nextLine(); // 버퍼 지우기


		for(int i = 0; i <row;i++) {
			String data =  sc.nextLine();
			for(int j = 0; j<col;j++) {
				visit[i][j] =data.charAt(j) - '0';
			}
		}
		int result = 0;
		for(int i = 0; i <row;i++) {
			for(int j = 0; j<col;j++) {
				if(dfs(i,j)) {
					result ++;
				}
			}
		}
		System.out.println(result);

		
	
	}

	public static boolean dfs(int x,int y) {
		//범위 벗어나는 경우 종료
		if(x<=-1||x>=row||y<=-1||y>=col) {
			return false;
		}
		
		//현재 노드를 아직 방문하지 않았다면
		if(visit[x][y]==0) {
			visit[x][y] = 1; // 방문처리
			//인접 노드 방문 상 하 좌 우 위치들을 모두 재귀적으로 호출
			dfs(x-1,y);
			dfs(x,y-1);
			dfs(x+1,y);
			dfs(x,y+1);
			//그러고 true를 반환하여 카운트를 증가시킴.
			return true;
		}
		return false;
		
		
	}


}
