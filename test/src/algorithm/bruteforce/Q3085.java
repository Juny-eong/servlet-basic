package algorithm.bruteforce;


import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Q3085 {
	
	private static char[][] map;
	private static int N;
	private static int max;
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		
		/* create map */
		for (int i = 0; i < N; i++) {
			
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		/* 가로 체크 */
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < N - 1; j++) {
				
				/* 바꿔서 최대값 구한 후 다시 원상복귀 */
				swap(i, j, i, j + 1);
				arrCheck();
				swap(i, j, i, j + 1);
			}
		}
		
		/* 세로 체크 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				
				swap(j, i, j + 1, i);
				arrCheck();
				swap(j, i, j + 1, i);
			}
		}
		
		System.out.println(max);
		br.close();
		
		
	}
	
	private static void arrCheck() {
		
		/* 1. 가로 체크 */
		for (int i = 0; i < N; i++) {
			int count = 1;
			
			for (int j = 0; j < N - 1; j++) {
				
				if (map[i][j] == map[i][j + 1]) {
					count++;
				}
				else {
					count = 1;
				}
				
				max = Math.max(count, max);
			}
		}
		
		/* 2. 세로 체크 */
		for (int i = 0; i < N; i++) {
			int count = 1;
			
			for (int j = 0; j < N - 1; j++) {
				if (map[j][i] == map[j + 1][i]) {
					count++;
				}
				else {
					count = 1;
				}
				
				max = Math.max(count, max);
			}
		}
		
	}
	
	private static void swap(int x, int y, int a, int b) {
		char temp = map[x][y];
		map[x][y] = map[a][b];
		map[a][b] = temp;
	}
}
