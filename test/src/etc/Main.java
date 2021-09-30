package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int[][] newMap;
	static int[][] copyMap;
	static boolean[][] isVisited;
	static int[] point;
	static int N;
	static int count = 1;
	static int startPoint = 0;
	static int ans = 999999;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		newMap = new int[N][N];
		copyMap = new int[N][N];
		isVisited = new boolean[N][N];
		
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		copyOriginalMap();
		
		initNewMap();

		/* bfs */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (newMap[i][j] != 0) {
					isVisited = new boolean[N][N];
					checkDistance(i, j);
					printMap();
					copyOriginalMap();
					
					initNewMap();
				}
				
			}
		}
		System.out.println("ans : " + ans);
		
	}
	
	static void initNewMap() {
		newMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dfs(i, j) == true) {
					count++;
				}
			}
		}
		count = 1;
	}
	
	static boolean dfs(int x, int y) {
		if (x >= N || x < 0 || y >= N || y < 0) {
			return false;
		}
		
		if (copyMap[x][y] != 0) {
			copyMap[x][y] = 0;
			newMap[x][y] = count;
			dfs(x + 1, y);
			dfs(x - 1, y);
			dfs(x, y + 1);
			dfs(x, y - 1);
			return true;
		}
		else {
			return false;
		}
	}
	
	static void checkDistance(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, 0));
		startPoint = newMap[x][y];
		isVisited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int tempX = point.x + dx[i];
				int tempY = point.y + dy[i];
				
				if ((0 <= tempX && tempX < N && 0 < tempY && tempY < N) // 유효한 필드
						&& !isVisited[tempX][tempY]						// 방문하지 않은 곳
						&& newMap[tempX][tempY] != startPoint) {		// 바다 혹은 다른 대륙 (유의미한 움직임)
					
					isVisited[tempX][tempY] = true;
					if (newMap[tempX][tempY] == 0) {
						queue.offer(new Point(tempX, tempY, point.value + 1));
					}
					else {
						ans = Math.min(ans, point.value);
					}
				}
			}
		}
	}
	
	static void printMap() {
		System.out.println("----------new map-----------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(newMap[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void printCopyMap() {
		System.out.println("-------copy map----------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(copyMap[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	static void copyOriginalMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		printCopyMap();
	}
	
	
	
	static class Point {
		int x;
		int y;
		int value;
		
		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	
}
