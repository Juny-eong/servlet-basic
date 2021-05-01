package algorithm.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1011 {
	
	/**
	 * 1 : 1			--> 1
	 * 2 : 1 1			--> 2
	 * 3 : 1 1 1		--> 3
	 * 4 : 1 2 1		--> 3	--> 2*2 - 1
	 * 5 : 1 2 1 1		--> 4
	 * 6 : 1 2 2 1		--> 4
	 * 7 : 1 2 2 1 1	--> 5
	 * 8 : 1 2 2 2 1	--> 5
	 * 9 : 1 2 3 2 1	--> 5	--> 3*2 - 1
	 * 10: 1 2 3 2 1 1	--> 6
	 */
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int start = 0;
		int end = 0;
		
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			System.out.println(operationCount(start, end));
			
		}
	}
	
	public static int operationCount(int x, int y) {
		
		int distance = y - x;
		int max = (int) Math.sqrt(distance);
		
		if (max == Math.sqrt(distance)) {
			return max * 2 - 1;
		}
		else if (max * max + max >= distance) {
			return max * 2;
		}
		else {
			return max * 2 + 1;
		}

	}

}
