package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2133 {
	
	static String dp[] = new String[1001];
	// 0 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp[1] = "SK";
		dp[2] = "CY";
		dp[3] = "SK"; // dp[4] = "
		
		for (int i = 4; i <= N; i++) {
			if (  "SK".equals(dp[i-3])  ) {
				dp[i] = "CY";
			}
			else {
				dp[i] = "SK";
			}
		}
		
		System.out.println(dp[N]);
		
	}

}
