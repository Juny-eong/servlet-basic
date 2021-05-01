package algorithm.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2609 {
	
	/**
	 * A, B의 최대공약수 / 최소공배수
	 */

	public static void main(String[] args) throws Throwable {
		
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int bigOne = Math.max(A, B);
			int smallOne = Math.min(A, B);
			
			int gcd = 1;
			int lcm = A * B;
			
			
			for (int i = smallOne; i > 1; i--) {
				if (bigOne % i == 0 && smallOne % i == 0) {
					gcd = i;
					break;
				}
			}
		
			
			for (int i = bigOne; i < lcm; i++) {
				if (i % bigOne == 0 && i % smallOne == 0) {
					lcm = i;
					break;
				}
			}
		
			System.out.println(gcd);
			System.out.println(lcm);
		
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
