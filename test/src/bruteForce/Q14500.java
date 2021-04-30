package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {
	
	public static int[][] map;
	public static int N;
	public static int M;
	public static int count = 0;
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int maxValue = 0;
		
		/* inputÀ¸·Î ¸Ê »ý¼º */
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int y = 0; y < N; y++) {
			
			for (int x = 0; x < M; x++) {
				
				for (int i = 0; i < 4; i++) {
//					maxValue = map[getMaxValue(map, y, x)[0]][getMaxValue(map, y, x)[0]];
					
				}
			}
		}
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
