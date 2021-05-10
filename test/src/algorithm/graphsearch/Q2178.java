package algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
	
	/**
	 * �̷�ã��
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
		
		/* ������ ĭ�� ���� �� (������������ �Ÿ�) */
		System.out.println(map[N - 1][M - 1]);
		
		br.close();
	}
	
	public static void bfs(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int location[] = q.poll();
			visited[x][y] = true;
			
			/* �ش� ������ ���� �� �������� �˻� */
			for (int dir = 0; dir < 4; dir++) {
				int nextX = location[0] + dx[dir];
				int nextY = location[1] + dy[dir];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					
					/* ���̸鼭 (1) �湮���� ���� ������ ã�ư��� */
					if (map[nextX][nextY] != 0 && !visited[nextX][nextY]) {
						q.offer(new int[] {nextX, nextY});
						visited[nextX][nextY] = true;
						
						/* �Ÿ� + 1 */
						map[nextX][nextY] = map[location[0]][location[1]] + 1;
					}
				}
			}
		}
		
	}

}
