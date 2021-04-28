package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11726 {
	
	/**
	 * 2 X n 타일링
	 * 
	 * n = 1 : 1 --> 세로블럭 하나
	 * n = 2 : 2 --> 사각형은 2가지
	 * n = 3 : n(2) + n(1) ? --> 
	 * n = 4 : n(3) + n(2) ?
	 */
	static int[] dp;
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		
		
		
		System.out.println(topDown(N));
		
		
		
	}
	
	public static int topDown(int n) {
		
		if (n == 0 || n == 1) return 1;
		if (dp[n] > 0) return dp[n];
		
		dp[n] = topDown(n-1) + topDown(n-2);
		
		dp[n] %= 10007;
		
		return dp[n];
	}

}
