package algorithm.bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {
	
	private static boolean[][] visited;
	private static int[][] map;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, -1, 0, 1 };
	private static int N;
	private static int M;
	private static int max;
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		max = 0;
		

		/* input으로 맵 생성 */
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int y = 0; y < N; y++) {
			
			for (int x = 0; x < M; x++) {
				
				DFS(y, x, 0, 0);
				Exception(y, x);
			}
		}
		System.out.println(max);
	}
	
	public static void DFS(int x, int y, int depth, int sum) {
		
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		/* 상하좌우로 움직인다. */
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			/* 범위를 벗어나는 경우 제외 */
			if (nextX < 0 || nextY < 0 || nextX >=N || nextY >= M) 
				continue;
			
			/* 이미 방문한 경로 제외 */
			if (visited[nextX][nextY]) 
				continue;
			
			visited[nextX][nextY] = true;
			DFS(nextX, nextY, depth + 1, sum + map[nextX][nextY]);
			visited[nextX][nextY] = false; // 다시 초기화해준다.
		}
		
	}
	
	public static void Exception(int x, int y) {
		int wing = 4;
		int min = Integer.MAX_VALUE;
		int sum = map[x][y];
		
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if (wing <= 2) return;
			
			if (nextX < 0 || nextY < 0 || nextX >=N || nextY >= M) {
				wing--;
				continue;
			}
			min = Math.min(min,  map[nextX][nextY]);
			sum = sum + map[nextX][nextY];
		}
		
		if (wing ==4) {
			sum = sum - min;
		}
		max = Math.max(max, sum);
	}
	
	public static int[] getMaxValue(int[][] map, int y, int x) {
		
		int tmp[] = new int[2];
		int leftValue = 0;
		int rightValue = 0;
		int upValue = 0;
		int downValue = 0;
		
		if (x > 0) leftValue = map[y][x-1];
		if (x < N) rightValue = map[y][x+1];
		if (y > 0) upValue = map[y-1][x];
		if (y < M) downValue = map[y+1][x];
		
		int subMax1 = Math.max(leftValue, rightValue);
		int subMax2 = Math.max(upValue, downValue);
		int max = Math.max(subMax1, subMax2);
		
		if (max == leftValue) {
			tmp[0] = y; 
			tmp[1] = x-1;
		}
		else if (max == rightValue) {
			tmp[0] = y;
			tmp[1] = x+1;
		}
		else if (max == upValue) {
			tmp[0] = y-1;
			tmp[1] = x;
		}
		else {
			tmp[0] = y + 1;
			tmp[1] = x;
		}
		
		return tmp;

	}

}
