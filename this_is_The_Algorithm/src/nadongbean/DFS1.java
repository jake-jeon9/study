package nadongbean;

import java.util.Scanner;

public class DFS1 {

	static int[][] visit =new int [1000][1000];
	static int row,col;
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		sc.nextLine(); // ���� �����


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
		//���� ����� ��� ����
		if(x<=-1||x>=row||y<=-1||y>=col) {
			return false;
		}
		
		//���� ��带 ���� �湮���� �ʾҴٸ�
		if(visit[x][y]==0) {
			visit[x][y] = 1; // �湮ó��
			//���� ��� �湮 �� �� �� �� ��ġ���� ��� ��������� ȣ��
			dfs(x-1,y);
			dfs(x,y-1);
			dfs(x+1,y);
			dfs(x,y+1);
			//�׷��� true�� ��ȯ�Ͽ� ī��Ʈ�� ������Ŵ.
			return true;
		}
		return false;
		
		
	}


}
