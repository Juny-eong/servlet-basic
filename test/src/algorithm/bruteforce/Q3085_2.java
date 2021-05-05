package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3085_2 {

	
	static char[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;
	static int max = -1;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N + 1][N + 1];
		
		
		/* create map */
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		
		/* traverse map */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				for (int way = 0; way < 4; way++) {
					int forX = i + dx[way];
					int forY = j + dy[way];
					
					if (!isValidLocation(forX, forY)) {
						continue;
					}
					
					max = Math.max(max, checkInput(i, j, forX, forY));
				}
			}
		}
		
		System.out.println(max + 1);
		
	}
	
	
	public static void swap(int x, int y, int forX, int forY) {
		
		char temp = map[x][y];
		map[x][y] = map[forX][forY];
		map[forX][forY] = temp;
	}
	
	
	public static int countCheck(int caseNumber, int x, int y) {
		
		int nextX = x + dx[caseNumber];
		int nextY = y + dy[caseNumber];
		
		if (!isValidLocation(nextX, nextY)) {
			return 0;
		}
		
		/* 체크한 방향(상/하/좌/우)의 값과 현재 값이 같으면 해당 위치에서 재귀 */
		if (map[x][y] == map[nextX][nextY]) {
			return countCheck(caseNumber, nextX, nextY) + 1;
		}
		else {
			return 0;
		}
	
	}
	
	public static int checkInput(int x, int y, int forX, int forY) {
		
		swap(x, y, forX, forY);
		int virtical = countCheck(1, x, y) + countCheck(3, x, y);
		int horizontal = countCheck(0, x, y) + countCheck(2, x, y);
		swap(x, y, forX, forY);
		
		return Math.max(virtical, horizontal);
	}
	
	public static boolean isValidLocation(int x, int y) {
		return (0 <= x && x < N && 0 <= y && y < N);
	}
	
}
