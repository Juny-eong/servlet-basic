package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9095 {
	
	/**
	 * 1, 2, 3의 조합의 경우의 수
	 * 
	 * @param args
	 */
	
	static int dp[] = new int[11];
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
		
	}

}
