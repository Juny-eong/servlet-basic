package algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {
	
	/**
	 * Depth-First Search (Stack) / Breadth-First Search (Queue)
	 */
	
	static int map[][];
	static boolean[] visit;
	static int N;
	static int M;
	static int V;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		/* input 정점의 시작이 0이 아닌 1 이므로 맞추기 위해 N+1 */
		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(map[i], 0);
		}
		Arrays.fill(visit, false);
		
		
		/* 간선 연결 상태 저장 */
		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			
			map[a][b] = 1; // a가 b와 연결되어 있다면
			map[b][a] = 1; // b도 a와 연결되어 있다
		}
		
		dfs(V);
		System.out.println();
		
		Arrays.fill(visit, false);
		
		bfs(V);
		
		br.close();
	}
	
	
	public static void dfs(int i) {
		
		visit[i] = true;
		System.out.print(i + " ");
		
		for (int j = 1; j < N + 1; j++) {
			if(map[i][j] == 1 && visit[j] == false) {
				dfs(j);
			}
		}
	}
	
	public static void bfs(int i) {
		
		Queue<Integer> q = new LinkedList<>();
		
		/* 출발점을 queue에 넣고 방문 기록 */
		q.offer(i);
		visit[i] = true;
		
		/* queue가 빌 때까지 수행 */
		while(!q.isEmpty()) {
			
			/* 하나씩 뽑아 확인한다 */
			int temp = q.poll();
			System.out.print(temp + " ");
			
			/* queue에서 뽑은 정점과 연결된 모든 정점을 체크 */
			for (int k = 1; k < N + 1; k++) {
				
				/* 연결되어있고 방문한 적 없는 정점의 경우 queue에 넣고 방문 기록 */
				if(map[temp][k] == 1 && visit[k] == false) {
					q.offer(k);
					visit[k] = true;
				}
			}
		}
		
	}
	
	
	
	
}
