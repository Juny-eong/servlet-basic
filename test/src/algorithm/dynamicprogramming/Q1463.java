package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1463 {
	
	/**
	 * Bottom-Up 점화식
	 * dp[N] 은 N을 1로 만들기 위한 최소 횟수
	 * 0, 1은 연산 횟수 0으로 제외
	 * 2부터 	dp[N] = dp[N-1] + 1
	 * 		dp[N] = dp[N/2] + 1
	 * 		dp[N] = dp[N/3] + 1
	 * 
	 * 셋 중, 가장 작은 값을 dp[N]에 저장한다. --> N이 1이 되
	 * 
	 * 
	 */

	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int input = Integer.parseInt(st.nextToken());

		int dp[] = new int[input + 1];
		
		dp[0] = 0;
		dp[1] = 0;
		
		for (int i = 2; i <= input; i++) {
			dp[i] = dp[i-1] + 1;
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1); 
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		System.out.println(dp[input]);
		
		br.close();

	}
}
