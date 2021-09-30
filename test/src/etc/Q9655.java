package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9655 {

	static int[] dp = new int[31];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 3;
		dp[3] = 0;
		dp[4] = 11;
		for (int i = 5; i <= N; i++) {
			if (i % 2 != 0) {
				dp[i] = 0;
			}
			else {		
				dp[i] = (int)Math.pow(dp[2], (i / 2))
						
						+ (  2 * dp[2] * ((i - 2) / 2)  );
			}
		}
		System.out.println(dp[N]);
	}
}
