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
	//��ü �� ������
	public static int[][] map = new int[201][201];
	public static int n,m; //n m�ޱ�
	
	//�̵��� ���� ���� (�� �� �� �� )
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,1,-1};
	

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();//���� ����
		
		//2���� ����Ʈ�� �� ���� �Է¹ޱ�
		for(int i = 0; i<n;i++) {
			String item = sc.nextLine();
			for(int j = 0; j<m;j++) {
				 map[i][j] = item.charAt(j) - '0';
			} 
		}
		
		
		
		//bfs�� ������ ��� ���
		System.out.println(bfs(0,0));
	}
	

	
	public static int bfs(int x,int y) {
		System.out.println("bfs ȣ��� x : "+x+", Y :"+y);
		//ťQueue ����
		Queue<Node> q= new LinkedList<>();
		q.offer(new Node(x,y));
		
		//ť�� �������� �ݺ�
		while(!q.isEmpty()) {
			
			Node node = q.poll();
			x = node.getX();
			y = node.getY();
			
			//���� ��ġ���� 4���� ���������� ����Ȯ��
			for(int i = 0; i<4;i++) {
				//���� �̵��� ��ġ ���� ������. 
				int nx = x + dx[i];
				int ny = y+ dy[i];
				
				//�̷ΰ� ������ ����� ��� �����ϱ�
				if(nx<0||nx>=n||ny<0||ny>=m) continue;
				
				//�ش� ������ ���� ��� 
				if(map[nx][ny]== 0 ) continue;

				//�ش� ��带 ó�� �湮�ϴ� ��쿡�� �ִܰŸ� ���
				if(map[nx][ny] == 1) {
					map[nx][ny] = map[x][y] +1;
					q.offer(new Node(nx,ny));
					System.out.println("���� �� ������ ����? "+ map[nx][ny]);
				}
			}
			
			
			
		}
		//���� ������ �Ʒ������� �ִܰŸ� ��ȯ
		return map[n-1][m-1];
	}
		
}
