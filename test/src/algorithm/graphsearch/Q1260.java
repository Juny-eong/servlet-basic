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
		
		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(map[i], 0);
		}
		Arrays.fill(visit, false);
		
		
		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		dfs(V);
		System.out.println();
		
		Arrays.fill(visit, false);
		
		bfs(V);
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
		q.offer(i);
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			
			for (int k = 1; k < N + 1; k++) {
				if(map[temp][k] == 1 && visit[k] == false) {
					q.offer(k);
					visit[k] = true;
				}
			}
		}
		
	}
	
	
	
	
}
