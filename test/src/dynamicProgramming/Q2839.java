package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2839 {
	
	/**
	 * input : N
	 * A = 3 / B = 5
	 * 5로 나눈 나머지 : 
	 * 
	 * 	0 : N / 5			--> 5 몇 개로 나누어진다. --> (N / 5)							: x
	 * 	1 : 5 + 1 = 6 		--> 3 두 개로 나누어진다. --> (N / 5) - 1(빠지는 5) + 2(들어가는 3)	: x + 1
	 * 	2 : 5 + 5 + 2 = 12 	--> 3 네 개로 나누어진다. --> (N / 5) - 2(빠지는 5) + 4(들어가는 3)	: x + 2
	 * 	3 : N / 5 + 3		--> 3 한 개로 나누어진다. --> (N / 5) + 1(들어가는 3)				: x + 1
	 * 	4 : 5 + 4 = 9		--> 3 세 개로 나누어진다. --> (N / 5) - 1(빠지는 5) + 3(들어가는 3)	: x + 2
	 * 
	 * 	위 경우, 최대로 땡겨 돌려막는 경우 : 12, 즉 12 이상의 모든 수는 땡겨서 돌려막으면 5와 3으로 해결된다.
	 * 	하지만 반대로, 12보다 작은 경우는 땡겨서 안 될수도 있으니 심사가 필요하다.	-->	4, 7				: -1
	 */
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		
		if (N == 4 || N == 7) 
			System.out.println(-1);
		
		else if (N % 5 == 0)
			System.out.println(N / 5);
		
		else if (N % 5 == 1 || N % 5 == 3)
			System.out.println(N / 5 + 1);
		
		else if (N % 5 == 2 || N % 5 == 4)
			System.out.println(N / 5 + 2);
		
		br.close();
	}
}
