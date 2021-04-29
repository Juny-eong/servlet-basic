package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1003 {
	
	/**
	 * 피보나치 수 구하기 -> 0, 1호출 횟수
	 * 
	 * 1 : 1				--> 0 1
	 * 2 : 0 1				--> 1 1
	 * 3 : 0 1 1			--> 1 2
	 * 4 : 0 0 1 1 1		--> 2 3
	 * 5 : 0 0 0 1 1 1 1 1	--> 3 5
	 * 
	 * --> f(N)일 때, 0 : f(N-1), 1 : f(N)
	 * 
	 * --> 
	 */
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int zero = 1;
			int one = 0;
			int sum = 1;
			
			for (int j = 0; j < N; j++) {
				zero = one;
				one = sum;
				sum = zero + one;
			}
			System.out.println(zero + " " + one);
		}
	
	}
	
}


