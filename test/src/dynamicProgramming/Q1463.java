package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1463 {
	
	/**
	 * 아래 내용 순차적으로 반복
	 * 	1) 3으로 나누어지면 나눈다
	 * 	2) 나누어지지 않은 경우, -1을 한 값이 3으로 나누어지면 뺀다.
	 * 	3) (2)가 해당되지 않으면 2로 나눈다.
	 * 	4) -1 한다.
	 * 
	 * 	**** -1 -> /3 의 경우 보다, /2 -> /2 의 경우가 우선되어야 한다. ****
	 */

	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int input = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		while (input != 1) {
			if (input % 3 == 0) {
				input /= 3;
				cnt++;
				continue;
			}
			else if (((float)input / 2) % 2 == 0) { // 4로 나누어지는 경우
				input /= 2;
				cnt++;
				continue;
			}
			else if ((input - 1) % 3 == 0) { // -1 한 값이 3으로 나누어지는 경우
				input -= 1;
				cnt++;
				continue;
			}
			else if (input % 2 == 0) {
				input /= 2;
				cnt++;
				continue;
			}
			else {
				input -= 1;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
