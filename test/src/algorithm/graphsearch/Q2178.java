package algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
	
	/**
	 * 미로찾기
	 */
	
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		
		/* 마지막 칸에 쓰인 수 (시작점부터의 거리) */
		System.out.println(map[N - 1][M - 1]);
		
		br.close();
	}
	
	public static void bfs(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int location[] = q.poll();
			visited[x][y] = true;
			
			/* 해당 정점에 대해 네 방향으로 검사 */
			for (int dir = 0; dir < 4; dir++) {
				int nextX = location[0] + dx[dir];
				int nextY = location[1] + dy[dir];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					
					/* 길이면서 (1) 방문하지 않은 곳으로 찾아간다 */
					if (map[nextX][nextY] != 0 && !visited[nextX][nextY]) {
						q.offer(new int[] {nextX, nextY});
						visited[nextX][nextY] = true;
						
						/* 거리 + 1 */
						map[nextX][nextY] = map[location[0]][location[1]] + 1;
					}
				}
			}
		}
		
	}

}
