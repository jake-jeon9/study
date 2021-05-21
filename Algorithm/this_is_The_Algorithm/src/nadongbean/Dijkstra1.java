package nadongbean;

import java.util.*;

public class Dijkstra1 {
	
	public static final int INF = (int)1e9;//최대값으로 설정하는 변수

	//노드의 갯수  N , 간선의 수 M , start 시작노드
	//maximum node 100,000
	public static int n,m,start;
	
	//각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
	public static ArrayList<ArrayList<Node1>> graph =new ArrayList<ArrayList<Node1>>();
	
	//방문한 적이 있는지 체크하는 배열
	public static boolean[] isVisited = new boolean[100001]; 
	
	//�최단 거리 테이블 만들기
	public static int[] md = new int[100001];
	
	//방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
	public static int getSmallestNode() {
		int min_value = INF;
		int index = 0;//가장 최단 거릭가 짧은 노드(인덱스)
		for(int i= 1;i<=n;i++) {
			
			//노드 md가 minvalue보다 작고, 방문한적이 없으면 index와 min value 적용시켜서 다음 노드랑 비교 하여 최소값을 리턴
			if(md[i] < min_value && !isVisited[i]) {
				min_value = md[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void dijkstra(int start) {
		//시작 노드 거리 초기화
		md[start] = 0;

		//먼저 방문 처리 
		isVisited[start] = true;
		
		//해당 노드에 인접한 노드들의 정볼르 꺼내옴
		for(int j = 0 ; j<graph.get(start).size();j++) {
			md[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
		}
		
		//시작 노드를 제외한 전체 n-1개의 노드에 대해 반복
		for(int i = 0; i<n-1;i++) {
			//현재 최단거리가 가장 짧은 노드를 꺼내서, 방문처리
			int now = getSmallestNode();
			isVisited[now] = true;
			
			//현재 노드와 연결된 다른 노드들 확인
			for(int j = 0;j<graph.get(now).size();j++) {
				int cost = md[now] + graph.get(now).get(j).getDistance();
				
				//현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
				if(cost <md[graph.get(now).get(j).getIndex()]) {
					md[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//노드의 갯수  N , 간선의 수 M , start 시작노드
		n = sc.nextInt();
		m = sc.nextInt();
		start =sc.nextInt();
		
		//그래프 초기화
		for(int i = 0; i<=n;i++) {
			graph.add(new ArrayList<Node1>());
		}
		
		//모든 간선 정보를 입력받기
		for(int i=0; i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			//a번 노드에서 b번 노드로 가는 비용이 c라는 의미
			graph.get(a).add(new Node1(b,c));
		}
		
		//최단거리를 모두 무한으로 초기화
		Arrays.fill(md,INF);
		
		//다익스트라 알고리즘 실행
		dijkstra(start);
		
		//모든 노드가 가기 위한 최단거리를 출력
		for(int i = 1; i<=n;i++) {
			//도달할 수 없는 경우, 무한(INFINITY) 이라고 출력
			if(md[i]== INF) {
				System.out.println("INFINITY");
			}else {
				//도달찰 수 있는 경우 거리를 출력
				System.out.println(md[i]);
			}
		}
		
		 System.out.println( md[n]);
				
	}
}

//노드 클래스를 만들어 정의 - 인접한 노드를 정의
class Node1 {
	
	private int index;
	private int distance;
	
	public Node1(int index, int distance) {
		super();
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
