package nadongbean;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {

	private int x;
	private int y;
	
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	
}

public class BFS2 {
	//전체 맵 사이즈
	public static int[][] map = new int[201][201];
	public static int n,m; //n m받기
	
	//이동할 방향 정의 (좌 우 하 상 )
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,1,-1};
	

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();//버퍼 비우기
		
		//2차원 리스트의 맵 정보 입력받기
		for(int i = 0; i<n;i++) {
			String item = sc.nextLine();
			for(int j = 0; j<m;j++) {
				 map[i][j] = item.charAt(j) - '0';
			} 
		}
		
		
		
		//bfs를 수행한 결과 출력
		System.out.println(bfs(0,0));
	}
	

	
	public static int bfs(int x,int y) {
		System.out.println("bfs 호출됨 x : "+x+", Y :"+y);
		//큐Queue 구현
		Queue<Node> q= new LinkedList<>();
		q.offer(new Node(x,y));
		
		//큐가 빌때까지 반복
		while(!q.isEmpty()) {
			
			Node node = q.poll();
			x = node.getX();
			y = node.getY();
			
			//현재 위치에서 4가지 방향으로의 위차확인
			for(int i = 0; i<4;i++) {
				//다음 이동할 위치 값을 가져옴. 
				int nx = x + dx[i];
				int ny = y+ dy[i];
				
				//미로가 범위를 벗어났을 경우 무시하기
				if(nx<0||nx>=n||ny<0||ny>=m) continue;
				
				//해당 공간이 벽인 경우 
				if(map[nx][ny]== 0 ) continue;

				//해당 노드를 처음 방문하는 경우에만 최단거리 기록
				if(map[nx][ny] == 1) {
					map[nx][ny] = map[x][y] +1;
					q.offer(new Node(nx,ny));
					System.out.println("현재 맵 누적된 값은? "+ map[nx][ny]);
				}
			}
			
			
			
		}
		//가장 오른쪽 아래까지의 최단거리 반환
		return map[n-1][m-1];
	}
		
}
